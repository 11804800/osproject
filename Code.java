# osproject
os project
import java.util.*;
class roundrobin { 
    public static void roundRobin(String p[], int a[], 
                                  int b[], int n) 
    { 
        int res = 0; 
        int resc = 0; 
        String seq = new String(); 
        int res_b[] = new int[b.length]; 
        int res_a[] = new int[a.length]; 
        for (int i = 0; i < res_b.length; i++) { 
            res_b[i] = b[i]; 
            res_a[i] = a[i]; 
        }
        int t = 0; 
        int w[] = new int[p.length]; 
        int comp[] = new int[p.length]; 
        while (true) { 
            boolean flag = true; 
            for (int i = 0; i < p.length; i++) { 
                if (res_a[i] <= t) { 
                    if (res_a[i] <= n) { 
                        if (res_b[i] > 0) { 
                            flag = false; 
                            if (res_b[i] > n) { 
                                t = t + n; 
                                res_b[i] = res_b[i] - n; 
                                res_a[i] = res_a[i] + n; 
                            } 
                            else { 
                                t = t + res_b[i]; 
                                comp[i] = t - a[i]; 
                                w[i] = comp[i] - a[i]; 
                                res_b[i] = 0; 
                            } 
                        } 
                    } 
                    else if (res_a[i] > n) { 
                        for (int j = 0; j < p.length; j++) { 
                            if (res_a[j] < res_a[i]) { 
                                if (res_b[j] > 0) { 
                                    flag = false; 
                                    if (res_b[j] > n) { 
                                        t = t + n; 
                                        res_b[j] = res_b[j] - n; 
                                        res_a[j] = res_a[j] + n; 
                                    } 
                                    else { 
                                        t = t + res_b[j]; 
                                        comp[j] = t - a[j];
                                        w[j] = comp[j] - a[j]; 
                                        res_b[j] = 0; 
                                    } 
                                } 
                            } 
                        } 
                        if (res_b[i] > 0) { 
                            flag = false; 
                            if (res_b[i] > n) { 
                                t = t + n; 
                                res_b[i] = res_b[i] - n; 
                                res_a[i] = res_a[i] + n; 
                            } 
                            else { 
                                t = t + res_b[i]; 
                                comp[i] = t - a[i]; 
                                w[i] = comp[i] - a[i]; 
                                res_b[i] = 0; 
                            } 
                        } 
                    } 
                } 
                else if (res_a[i] > t) { 
                    t++; 
                    i--; 
                } 
            } 
            if (flag) { 
                break; 
            } 
        } 
        System.out.println("name          atime       btime      ctime     ttime"); 
        for (int i = 0; i < p.length; i++) { 
            System.out.println(" " + p[i] + "    " +a[i]+ "    "+b[i]+  "    " + comp[i] + "    " + w[i]);
            res = res + w[i]; 
            resc = resc + comp[i]; 
        }
     System.out.println("Average query time is "+ (float)res / p.length); 
        System.out.println("toatal  time spend in query is "+ (float)resc ); 
    } 
    public static void main(String args[]) 
    { 
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Enter 1 for teacher either 2 for student: ");
	 int a=sc.nextInt();
		if(a==1){
        //for teacher
        String name[] = { "Sehnaz mam", "Jyoti mam", "mayank sir", "Prachi mam" }; 
        int arrivaltime[] = { 0, 1, 2, 3 }; 
        int bursttime[] = { 10, 4, 5, 3 };
        int q = 2; 
        roundRobin(name, arrivaltime, bursttime, q); 
		}
		else if(a==2){
	    //for student
        String name[] = { "kanchan", "Suman", "Nikhil", "Prachi" }; 
        int arrivaltime[] = { 0, 2, 0, 1 }; 
        int bursttime[] = { 2, 7, 5, 9 };
        int q = 2; 
        roundRobin(name, arrivaltime, bursttime, q); 
		}
else
{
System.out.println(“Please enter from one to 2 only ”);
}
    } 
}
