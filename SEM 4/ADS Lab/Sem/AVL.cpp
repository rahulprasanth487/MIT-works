#include <iostream>
#include <stdlib.h>
using namespace std;


class Node
{
      public:
            int key,height;
            Node *right,*left;
};

int height(Node* node)
{
      if(node==NULL) return 0;
      return node->height;
}

int max(int x,int y)
{
      return (x>y)?x:y;
}

Node* newnode(int val)
{
      Node* temp=new Node();
      temp->left=temp->right=NULL;
      temp->key=val;
      temp->height=1;
      return temp;
}


Node* leftRotate(Node* node)
{
      Node* x=node->right;
      Node* temp=x->left;
      x->left=node;
      node->right=temp;

      x->height = max(height(x->left), height(x->right)) + 1;
      node->height = max(height(node->left), height(node->right)) + 1;
      return x;
}

Node* rightRotate(Node* node)
{
      Node* x=node->left;
      Node* temp=x->right;
      x->right=node;
      node->left=temp;

      x->height = max(height(x->left), height(x->right)) + 1;
      node->height = max(height(node->left), height(node->right)) + 1;
      return x;
}

int balacingFactor(Node* node)
{
      if (node == NULL)
            return 0;
      return height(node->left)-height(node->right);
}


Node* insert(Node* root,int key)
{
      if(root==NULL) return newnode(key);

      if(key < root->key)
            root->left =  insert(root->left,key);
      else if(key>root->key)
           root->right =  insert(root->right,key);
      else
      {
            return root;
      }

      int balance=balacingFactor(root);

      root->height=max(height(root->left),height(root->right))+1;

      if (balance > 1 && key < root->left->key)
            return rightRotate(root);

      if (balance > 1 && key > root->left->key)
      {
            root->left = leftRotate(root->left);
            return rightRotate(root);
      }

      if (balance < -1 && key > root->right->key)
            return leftRotate(root);

      if (balance < -1 && key < root->right->key)
      {
            // balance<-1&&key<node->right->key is the condition
            root->right = rightRotate(root->right);
            return leftRotate(root);
      }

      return root;
}


int inorder(Node* node)
{
      Node* temp=node;
      while (temp!=NULL)
      {
            if(temp->left==NULL) return temp->key;
            temp=temp->left;
      }

      return temp->key;
      
}



void preorder_display(Node *node)
{
      if (node != NULL)
      {
            cout << node->key << "  ";
            preorder_display(node->left);
            preorder_display(node->right);
      }
}


int main()
{
      Node *node=newnode(13);
      node=insert(node,10);
      node=insert(node,5);
      node=insert(node,12);
      node=insert(node,15);

      preorder_display(node);
}