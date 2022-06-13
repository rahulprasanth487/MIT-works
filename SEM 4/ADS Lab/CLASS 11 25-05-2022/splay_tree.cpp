#include <iostream>
using namespace std;
template <class t>
class node
{
public:
      t key;
      node *left;
      node *right;

      node *newNode(t key)
      {
            node *n = new node();
            n->left = NULL;
            n->right = NULL;
            n->key = key;
            return n;
      }
      node *leftRotate(node *x)
      {
            node *y = x->right;
            x->right = y->left;
            y->left = x;
            return y;
      }
      node *rightRotate(node *y)
      {
            node *x = y->left;
            y->left = x->right;
            x->right = y;
            return x;
      }

      node *splay(node *root, t key)
      {
            if (root == NULL)
                  return root;

            // check for left tree
            if (root->key > key)
            {
                  // check if left subtree is present
                  if (root->left == NULL)
                        return root;

                  // zig zig
                  if (root->left->key > key)
                  {
                        root->left->left = splay(root->left->left, key);
                        root = rightRotate(root);
                  }
                  // zig zag
                  else if (root->left->key < key)
                  {
                        root->left->right = splay(root->left->right, key);
                        if (root->left->right != NULL)
                        {
                              root->left = leftRotate(root->left);
                        }
                  }
                  return (root->left == NULL) ? root : rightRotate(root);
            }
            // for right tree
            else
            {
                  // check for right subtree
                  if (root->right == NULL)
                        return root;
                  // zag zag
                  if (root->right->key < key)
                  {
                        root->right->right = splay(root->right->right, key);
                        root = leftRotate(root);
                  }
                  // zag zig
                  else if (root->right->key > key)
                  {
                        root->right->left = splay(root->right->left, key);
                        if (root->right->left != NULL)
                        {
                              root->right = rightRotate(root->right);
                        }
                  }
                  return (root->right == NULL) ? root : leftRotate(root);
            }
      }

      node *search(node *root, t key)
      {
            return splay(root, key);
      }

      node *insert(node *root, t key)
      {
            if (root == NULL)
                  return newNode(key);


            // get the nearest leaf node to root
            root = splay(root, key);
            // check for duplicate
            if (root->key == key)
                  return root;

                  
            node *temp = newNode(key);
            if (root->key > key)
            {
                  temp->right = root;
                  temp->left = root->left;
                  root->left = NULL;
                  return temp;
            }
            else
            {
                  temp->left = root;
                  temp->right = root->right;
                  root->right = NULL;
                  return temp;
            }
            return root;
      }

      node *deleteNode(node *root, t key)
      {
            if (root == NULL)
                  return root;
            // check if present
            root = splay(root, key);
            if (root->key != key)
                  return root;
            node *temp;
            if (root->left == NULL)
            {

                  temp = root;
                  root = root->right;
            }
            else
            {
                  temp = root;
                  root = splay(root->left, key);
                  root->right = temp->right;
            }
            free(temp);
            return root;
      }

      void preorder(node *root)
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
      node<int> *root = NULL;
      int ch, key;
      cout << "-------------------------\n";
      cout << "\tSplay Tree\n";
      cout << "-------------------------\n";
      cout << "1) To insert \n2) To deleten\n3) To search\n4) To display in preorder\n5) To exit: ";

      while (1)
      {
            cout<<"Enter the choice = ";
            cin >> ch;
            switch (ch)
            {
            case 1:
                  cout << "Enter the element to insert: ";
                  cin >> key;
                  root = root->insert(root, key);
                  break;
            case 2:
                  cout << "Enter the element to delete: ";
                  cin >> key;
                  root = root->deleteNode(root, key);
                  break;
            case 3:
                  cout << "Enter the element to search: ";
                  cin >> key;
                  root = root->search(root, key);
                  if (root->key == key)
                  {
                        cout << "Found\n";
                  }
                  else
                  {
                        cout << "Not Found\n";
                  }
                  root->preorder(root);
                  cout << "\n";
                  break;
            case 4:
                  root->preorder(root);
                  cout << "\n";
                  break;
            case 5:
                  exit(1);
                  break;
            default:
                  break;
            }
      }
      // root->left = newNode(1);
      // root->right = newNode(9);
      // root->left->right = newNode(4);
      // root->left->right->left = newNode(2);
      // root->right->left = newNode(7);
      // root = deleteNode(root,4);
      // root->preorder(root);
      return 0;
}