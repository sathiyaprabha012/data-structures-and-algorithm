/*

Given the root of a Binary Search Tree (BST), convert it to a Greater Tree 
such that every key of the original BST is changed to the original key 
plus the sum of all keys greater than the original key in BST.

Example 1:
Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]


Example 2:
Input: root = [0,null,1]
Output: [1,null,1]
*/


//  Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
class Solution {
private :
    int sum = 0 ;

public:
    TreeNode* convertBST(TreeNode* root) {
        // we know that the right subtree will be greater than the current node 
        // so tranverse from the right subtree
        // RECURSIVE                                                                tc : O(n)        sc : O(h) (h-height of the tree)
        reverse_inorder(root);
        return root ;
    }

    TreeNode* reverse_inorder(TreeNode* root)
    {
        if (root != nullptr)
        {
            reverse_inorder(root->right);
            sum = sum + root->val  ;
            root->val = sum ;
            reverse_inorder(root->left);
        }
        return root ;
    }
};