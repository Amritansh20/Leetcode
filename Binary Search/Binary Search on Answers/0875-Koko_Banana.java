class Test {

    
    public static int findMax(int[] v){
        int maxi = Integer.MIN_VALUE;

        for(int i=0;i<v.length;i++){
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }

    public static long calculateHour(int[] v, int mid){
        long totalHour=0;
        for(int i=0;i<v.length;i++){
            totalHour+= Math.ceil( (double) v[i]/ (double)mid);
        }
        return totalHour;
    }

        // Write Your Code Here
       
    public static void main(String[] args) {
        int v[] = {7,15,6,3};
        int h =8;

        int low=1;
        int high = findMax(v);
        System.out.println("Initially high is at "+high);
        System.out.println("");
        System.out.println("");
        System.out.println("");

        while(low<=high){
            int mid = low + (high-low)/2;
            System.out.println("low is at "+ low);
            System.out.println("mid is at "+ mid);
            System.out.println("high is at "+ high);
            long hours = calculateHour(v,mid);
            System.out.println("Total Hours " + hours);
            System.out.println("");
            System.out.println("");
            System.out.println("");

            if(hours<=h)
            high=mid-1;
            else
            low = mid+1;
        }
        System.out.println(low);
    }
}

