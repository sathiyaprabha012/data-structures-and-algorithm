/* 
Given an array of integers temperatures represents the daily temperatures, 
return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]
*/


#include<iostream>
using namespace std;
#include<stack>
#include<vector>
class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& t) {  //tc : O(n)    sc:O(n)
        int n = t.size();
        vector<int> result(n,0);
        stack<int> s; //stores the indices
        s.push(n-1); //push the last index
        for (int i = n-2;i>=0;i--) // start with the second last elemt of the list
        {
            if(t[i] < t[s.top()]) // compare the current element with the top indexed element
                result[i] = s.top() - i; //difference between the indices
            else 
            {
                while(!s.empty() && t[s.top()]<=t[i]) // pop until you find the day t greater than current element in the stack
                    s.pop();
                if(!s.empty())
                    result[i] = s.top() - i;
            }
            s.push(i);
        }
        return result;
    }
};


int main() {
    Solution obj ;
    vector<int> t = {73,74,75,71,69,72,76,73};
    vector<int> res = obj.dailyTemperatures(t);
    for (int i : res)
        cout<< i << "\t" ;
    return 0;
}