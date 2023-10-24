class Solution
{
    public ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        ArrayList<Integer> list=new ArrayList<>();
        kthNode(root,list,target,k);
        Collections.sort(list);
        return list;
    }
    
    int kthNode(Node root,ArrayList<Integer> list,int target, int k){
        if(root==null) return -1;
        if(root.data==target){
            addToList(list,root.left,1,k);
            addToList(list,root.right,1,k);
            return 1;
        }
        
        int dist=kthNode(root.right,list,target,k);
        if(dist==k) list.add(root.data);
        else if(dist!=-1 && dist<k){
            addToList(list,root.left,dist+1,k);
        }
        if(dist!=-1) return dist+1;

        dist=kthNode(root.left,list,target,k);
        if(dist==k) list.add(root.data);
        else if(dist!=-1 && dist<k){
            addToList(list,root.right,dist+1,k);
        }
        if(dist!=-1) return dist+1;
        return -1;
    }
    
    void addToList(ArrayList<Integer> list,Node root,int dist,int k){
        if(root==null) return;
        if(dist==k){
            list.add(root.data);
            return;
        }
        addToList(list,root.left,dist+1,k);
        addToList(list,root.right,dist+1,k);
    }
};
