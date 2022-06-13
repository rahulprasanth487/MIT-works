#include <iostream>
using namespace std;

class Node
{
      public:
            int key;
            Node *left,*right;

            Node *newNode(int key)
            {
                  Node *n = new Node();
                  n->left = NULL;
                  n->right = NULL;
                  n->key = key;
                  return n;
            }
            Node *leftRotate(Node *x)
            {
                  Node *y = x->right;
                  x->right = y->left;
                  y->left = x;
                  return y;
            }
            Node *rightRotate(Node *y)
            {
                  Node *x = y->left;
                  y->left = x->right;
                  x->right = y;
                  return x;
            }

            Node* splay(Node* root,int key)
            {
                  if(root=NULL) return root;

                  if(root->key>key)
                  {
                        if(root->left==NULL) return root;
                        //zig zig
                        if (root->left->key > key)
                        {
                              root->left->left=splay(root->left->left,key);
                              root = rightRotate(root);
                        }

                        else if (root->left->key < key)
                        {
                              root->left->right = splay(root->left->right, key);
                              if(root->left->right!=NULL)
                              {
                                    root->left=leftRotate(root->left);
                              }
                        }

                        return (root->left==NULL)?root:rightRotate(root);
                  }
                  else
                  {
                        if(root->right==NULL) return root;

                        if(root->right->key<key)
                        {
                              root->right->right=splay(root->right->right,key);
                              root=leftRotate(root);
                        }
                        else if(root->right->key>key)
                        {
                              root->right->left=splay(root->right->left,key);
                              if(root->right->left!=NULL)
                              {
                                    root->right=rightRotate(root->right);
                              }
                        }

                        return (root->right==NULL)?root:leftRotate(root);
                  }
            }

            Node* insert(Node* root,int key)
            {
                  if(root==NULL) return newNode(key);
                  root=splay(root,key);
                  if(root->key==key) return root;

                  Node* temp=newNode(key);
                  if(root->key>key)
                  {
                        
                        temp->right=root;
                        temp->left=root->left;
                        root->left=NULL;
                        return temp;
                  }
                  else if(root->key<key)
                  {
                        temp->left=root;
                        temp->right=root->right;
                        root->right=NULL;
                        return temp;
                  }
                  return root;
            }
            void preorder(Node *root)
            {
                  if (root != NULL)
                  {
                        cout << root->key << " ";
                        preorder(root->left);
                        preorder(root->right);
                  }
            }
};

int main()
{
      Node* root=NULL;
      root = root->insert(root, 10);
      root = root->insert(root, 20);
      root = root->insert(root, 30);
      root->preorder(root);
      return 1;
}