// BINARY SEARCH TREE

#include<stdio.h>

#include<stdlib.h>

struct node
{
       int data;
       struct node *lc,*rc;
}*root;

void build_tree(struct node*);
void submenu();
void display(struct node*,int);
void search(struct node*,int);
void preorder(struct node*);
void inorder(struct node*);
void postorder(struct node*);
void insert(struct node *root, struct node *new_node);
struct node *get_node();
struct node* deletenode(struct node*,int);
struct node* FindMin(struct node* node);

int count=0,searchelementfound;


int main()
{
   
   struct node *new_node;
   char ans='N';
  
    int choice,exit=0;
    struct node *newnode;
    int element;

    
    while(exit==0)
    {
        	printf("\nMain Menu\n1.Insert\n2.Display\n3.Sub Menu\n4.Delete node\n5.Exit\nChoice:");
        	scanf("%d",&choice);
        	
        	switch(choice)
        	{
                          case 1: 
                         // do {
            new_node = get_node();
            printf("\nEnter The Element:");
            scanf("%d", &new_node->data);
            printf("Element Inserted!\n");

 
            if (root == NULL) /* Tree is not Created */
               root = new_node;
            else
               insert(root, new_node);
 
 /*
            printf("\nWant To enter More Elements?(y/n):");
            fflush(stdin);
            scanf("%s",&ans);
            */
         //} while (ans == 'N');
         break;
                          case 2: display(root,5);break;
                          case 3: submenu();break;
                          case 4: 
                          printf("Enter element to be deleted:");
                          scanf("%d",&element);
                          deletenode(root,element);break;
                          case 5: exit=1;break;
                          default:printf("Invalid choice entered!");
            }
    }
    
    return 0;
}

struct node *get_node() {
   struct node *temp;
   temp = (struct node *) malloc(sizeof(struct node));
   temp->lc = NULL;
   temp->rc = NULL;
   return temp;
}

void insert(struct node *root, struct node *new_node) 
{
   if (new_node->data < root->data) {
      if (root->lc == NULL)
         root->lc = new_node;
      else
         insert(root->lc, new_node);
   }
 
   if (new_node->data > root->data) {
      if (root->rc == NULL)
         root->rc = new_node;
      else
         insert(root->rc, new_node);
   }
}


void submenu()
{
     int choice,element;
     printf("\nSubmenu\n1.Preorder Traversal\n2.Inorder Traversal\n3.Post Order Traversal\n4.Go To Main Menu\nChoice:");
     scanf("%d",&choice);
     switch (choice)
     {
            
            case 1: printf("\n");
                    preorder(root);
                    printf("\n");
                    break;
            case 2: printf("\n");
                    inorder(root);
                    printf("\n");
                    break;
            case 3: printf("\n");
                    postorder(root);
                    printf("\n");
                    break;
            case 4: break;
            default: printf("Invalid Choice Entered!");
     }
}

void display(struct node *ptr,int l)
{
     int i;
     if(ptr!=NULL)
     {
                  display(ptr->rc,l+5);
                  for(i=0;i<l;i++)
                                  printf(" ");
                  printf("%d\n",ptr->data);
                  display(ptr->lc,l+5);
     } 
}



void preorder(struct node *ptr)
{
     if(ptr!=NULL)
     {
       printf("%d ",ptr->data);
       preorder(ptr->lc);
       preorder(ptr->rc);
     } 
}

void inorder(struct node *ptr)
{
     if(ptr!=NULL)
     {
         preorder(ptr->lc);
         printf("%d ",ptr->data);
         preorder(ptr->rc);
     }
}

void postorder(struct node *ptr)
{
     if(ptr!=NULL)
     {
      preorder(ptr->lc);
      preorder(ptr->rc);
      printf("%d ",ptr->data);
     }
}

struct node* deletenode(struct node *root,int data)
{
    if (root==NULL) return root;
    else if(data<root->data)
      root->lc=deletenode(root->lc,data);
    else if(data>root->data)
      root->rc=deletenode(root->rc,data);
    else
    {
      // No child
      if(root->lc ==NULL && root->rc==NULL)
      {
        free(root);
        root=NULL;
      }

      // One child
      else if(root->lc == NULL)
      {
        struct node *temp=root;
        root=root->rc;
        free(temp) ; 
      }
        else if(root->rc == NULL)
      {
        struct node *temp=root;
        root=root->lc;
        free(temp) ;
      }
        // 2 children
      else
      {
          struct node* temp= FindMin(root->rc);
          root->data = temp->data;
          root->rc = deletenode(root->rc,temp->data);
      }
      return root;
    }
}

struct node* FindMin(struct node* node) {
  struct node* current = node;
 
  /* loop down to find the leftmost leaf */
  while (current->lc != NULL) {
    current = current->lc;
  }
  return(current);
}