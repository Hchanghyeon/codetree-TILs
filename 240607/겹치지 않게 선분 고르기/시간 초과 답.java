import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


  private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  private static final List<Position> positions = new ArrayList<>();
  
  private static int max = 0;
  private static boolean[] visited;
  private static boolean[] checked;
  private static int N = 0;

  public static void main(String[] args) throws Exception {
      N = Integer.parseInt(bufferedReader.readLine());
  
      for(int i = 0; i < N; i++){
          final String[] line = bufferedReader.readLine().split(" ");
          final int x1 = Integer.parseInt(line[0]);
          final int x2 = Integer.parseInt(line[1]);
  
          positions.add(new Position(x1, x2));
      }
  
      visited = new boolean[N];
      checked = new boolean[1000];
      recursive(0);
      System.out.println(max);
  }

  private static void recursive(int depth){
     int value = checkRanged();
     max = Math.max(value, max);
  
     for(int i = depth; i < N; i++){
          if(!visited[i]){
              visited[i] = true;
              recursive(depth + 1);
              visited[i] = false;
          }
      }
  }
  
  private static int checkRanged(){
      Arrays.fill(checked, false);
      int count = 0;
  
      for(int j = 0; j < positions.size(); j++){
          if(visited[j]){
              for(int i = positions.get(j).getX1() - 1; i <= positions.get(j).getX2() - 1; i++){
                  if(checked[i]){
                      return 0;
                  }
  
                  checked[i] = true;
              }
              count++;
          }
      }
  
      return count;
  }
  
  public static class Position {
      private int x1;
      private int x2;
  
      Position(int x1, int x2){
          this.x1 = x1;
          this.x2 = x2;
      }
  
      public int getX1(){
          return x1;
      }
  
      public int getX2(){
          return x2;
      }
  }
}
