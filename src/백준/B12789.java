package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        Stack<Integer> delay = new Stack<>();

        int n =1;
        boolean check =false;

        while (true){
            if(!queue.isEmpty()) {
                if (queue.peek() != n) {
                    if (!delay.isEmpty()) {
                        if (delay.peek() == n) {
                            delay.pop();
                            n++;
                            continue;
                        }
                        delay.add(queue.poll());

                    }else {

                        delay.add(queue.poll());
                    }
                } else {
                    queue.poll();
                    n++;
                }
            }

            if(queue.isEmpty()&&delay.isEmpty()){
                System.out.println("안녕1");
                check=true;
                break;
            }

            if(queue.isEmpty()&&!delay.isEmpty()){
                System.out.println("안녕2");
                if(delay.peek()!=n){
                    break;
                }
            }

            if(!queue.isEmpty()&&delay.isEmpty()){
                System.out.println("안녕3");
                if(queue.peek()!=n){
                    break;
                }
            }

            if(!queue.isEmpty()&&!delay.isEmpty()){
                System.out.println("안녕4");
                if(delay.peek()!=n&&queue.peek()!=n){
                    break;
                }
            }

        }

        if(check){
            System.out.println("Nice");
        }else {
            System.out.println("Sad");
        }


    }
}
