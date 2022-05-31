#include <iostream>
#include <unistd.h>
using namespace std;

class Node
{
	public:
		int key;
		int height;
		Node *left,*right;
};

//--------------------------------------------------------------------------------------

int height(Node* n)
{
	if(n==NULL) return 0;
	return n->height;
}

//--------------------------------------------------------------------------------------


int max(int x,int y)
{
	return (x>y)?x : y;
}

//--------------------------------------------------------------------------------------


Node* leftRotate(Node* y)
{
	Node* x = y->right;
	Node* x_lft=x->left;

	x->left=y;
	y->right=x_lft;

	x->height=max(height(x->left),height(x->right))+1;
	y->height=max(height(y->left),height(y->right))+1;
	
	return x;
}

//--------------------------------------------------------------------------------------


Node* rightRotate(Node* y)
{
	Node* x = y->left;
	Node* x_rit=x->right;

	x->right=y;
	y->left=x_rit;

	x->height=max(height(x->left),height(x->right))+1;
	y->height=max(height(y->left),height(y->right))+1;
	
	return x;
}

//--------------------------------------------------------------------------------------

Node* newnode(int key)
{
	Node* temp=new Node();
	temp->key=key;
	temp->right=temp->left=NULL;
	temp->height=1;
	return temp;
}

//--------------------------------------------------------------------------------------

int balancingFactor(Node* node)
{
	if(node==NULL) return 0;
	return height(node->left)-height(node->right);
}

//--------------------------------------------------------------------------------------


Node* insert(Node* node, int key)
{
	//create new Node
	if(node==NULL) return newnode(key);

	//to insert the key
	if(key<node->key)
		node->left=insert(node->left,key);
	else if(key>node->key)
		node->right=insert(node->right,key);
	else
	{
		//if it is equal
		return node;
	}

	int balance = balancingFactor(node);

	node->height = 1+max(height(node->left),height(node->right));


	if(balance>1&&key<node->left->key)
		return rightRotate(node);

	if(balance<-1&&key>node->right->key)
		return leftRotate(node);

	if(balance>1&&key>node->left->key)
	{
		node->left = leftRotate(node->left);
		return rightRotate(node);
	}

	if(balance<-1&&key<node->left->key)
	{
		node->right = rightRotate(node->right);
		return leftRotate(node);
	}

	return node;
}

//--------------------------------------------------------------------------------------

void preorder_display(Node* node)
{
	if(node!=NULL)
	{
		cout<<node->key<<"  ";
		preorder_display(node->left);
		preorder_display(node->right);
	}
}

//--------------------------------------------------------------------------------------


int search(Node* node,int key)
{	
	while (node!=NULL)
	{
		if(node->key==key){
			cout<<"\nElement found\n";
			return 1;
		}
		if(key<node->key){
			node=node->left;
		}
		else node=node->right;
	}
	cout<<"\nElement Not found";
	return 0;
	
}

//--------------------------------------------------------------------------------------


int InorderSuccessor(Node* node)
{
	//return the minimum value;
	Node* current=node;

	if (current->left==NULL){
		return current->key;
	}

	while (current != NULL)
	{
		current = current->left;
	}
	
	return current->key;
}

//--------------------------------------------------------------------------------------


Node* deleteNode(Node* node,int key)
{
	if(node==NULL) return node;

	if(key<node->key)
		node->left=deleteNode(node->left,key);
	else if(key>node->key)
		node->right=deleteNode(node->right,key);
	else
	{
		//this the the case when the key entered matches the node
		if((node->left==NULL)||(node->right==NULL))
		{
			Node* temp=node->left?node->left:node->right;
			//the above one describes if any one is null then other will execute

			//here for no child;
			if(temp==NULL)
			{
				temp=node;
				node=NULL;
			}
			else{
				*node=*temp;
			}

			// removes the node
			free(temp);
		}

		else{
			int succor=InorderSuccessor(node->right);

			node->key=succor;

			node->right=deleteNode(node->right,succor);
		}
	}

	if (node == NULL)
		return node;

	//then do the same as insert to balace the tree

	int balance=balancingFactor(node);

	node->height=1+max(height(node->left),height(node->right));

	if(balance>1&&key<node->left->key) return rightRotate(node);

	if(balance>1&&key>node->left->key)
	{
		node->left=leftRotate(node->left);
		return rightRotate(node);
	}

	if(balance<-1&&key>node->right->key) return leftRotate(node);

	if (balance < -1 && key < node->right->key)
	{
		// balance<-1&&key<node->right->key is the condition
		node->right=rightRotate(node->right);
		return leftRotate(node);
	}

	return node;

}

//--------------------------------------------------------------------------------------

int main()
{
	Node *node=NULL;
	int ch;
	cout<<"\n1.INSERT\n2.DELETE\n3.DISPLAY\n4.SEARCH\n";
	while (1)
	{	int val,x;
		cout<<"\nEnter the choice = ";
		cin>>ch;
		if(ch==-1) return 1;

		switch (ch)
		{
		case 1:
			cout<<"\nEnter the value to insert = ";
			cin>>val;
			node=insert(node,val);
			break;
		
		case 2:
			cout << "\nEnter the value to delete = ";
			cin >> val;
			node = deleteNode(node, val);
			break;
		
		case 3:
			preorder_display(node);
			break;

		case 4:
			cout << "\nEnter the value to search = ";
			cin >> val;
			x = search(node, val);
			break;

		default:
			cout<<"Wrong choice";
			break;
		}
	}

	return 1;
	
}

//--------------------------------------------------------------------------------------
