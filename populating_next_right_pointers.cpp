// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this 

class Solution {
private:
    vector<vector<Node*>> vect;
    
    void level_order_trav(Node* root)
    {
        if(root == NULL)
            return;
        
        queue<Node*> nodeq;
        queue<int> levelq;
        
        Node* temp;
        int tlevel;
        
        nodeq.push(root);
        levelq.push(0);
        
        // Keep pushing in Queue and access sequentially
        while(!nodeq.empty())
        {
            temp = nodeq.front();
            nodeq.pop();
            
            tlevel = levelq.front();
            levelq.pop();
            
            cout << temp->val << endl;

            // If same level, add there   
            if(vect.size() == tlevel)
            {
                vector<Node*> temp_vect;
                
                temp_vect.push_back(temp);
                
                vect.push_back(temp_vect);
            }
            // If not, create new level
            else
                vect[tlevel].push_back(temp);
            
            // Push left node
            if(temp->left)
            {
                nodeq.push(temp->left);
                levelq.push(tlevel+1);
            }
            
            // Push Right node
            if(temp->right)
            {
                nodeq.push(temp->right);
                levelq.push(tlevel+1);
            }
        }  
    }
    
public:
    Node* connect(Node* root) {
        
        // Do level order traversal
        // And put the node in vector 
        level_order_trav(root);
        
        int j;
        
        for(int i = 0; i < vect.size(); i++)
        {
            j = 0;
            // Update the next pointers
            while(j < vect[i].size()-1)
            {
                vect[i][j]->next = vect[i][j+1];
                j++;
            }
            
        }
        return root;
    }
};