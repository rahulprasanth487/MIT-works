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

int height(Node* n)
{
	if(n==NULL) return 0;
	return n->height;
}


int max(int x,int y)
{
	return (x>y)?x : y;
}

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


Node* newnode(int key)
{
	Node* temp=new Node();
	temp->key=key;
	temp->right=temp->left=NULL;
	temp->height=1;
	return temp;
}


int balancingFactor(Node* node)
{
	if(node==NULL) return 0;
	return height(node->left)-height(node->right);
}


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



void preorder_display(Node* node)
{
	if(node!=NULL)
	{
		cout<<node->key<<"  ";
		preorder_display(node->left);
		preorder_display(node->right);
	}
}


void search(Node* node,int key)
{	
	while (node!=NULL)
	{
		if(node->key==key){
			cout<<"\nElement found\n";
			exit(0);
		}
		if(key<node->key){
			node=node->left;
		}
		else node=node->right;
	}
	cout<<"Element Not found";
	
}


int main()
{
	Node* node=NULL;
	node=insert(node,10);
	node=insert(node,20);
	node=insert(node,30);
	node=insert(node,40);
	node=insert(node,50);
	node=insert(node,60);

	cout<<"\n\nPreorder traversal = ";
	preorder_display(node);
	cout<<"\n\n";

	//Searching
	int sr;
	cout<<"Enter the number to search = ";
	cin>>sr;

	search(node,sr);
	

	return 1;

}