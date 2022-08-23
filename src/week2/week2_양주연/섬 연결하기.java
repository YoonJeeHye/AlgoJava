package week2.week2_양주연;

import java.util.*;
class Solution {
    class Edge implements Comparable<Edge>{ //간선 클래스
        int v1, v2, w;
        public Edge(int v1, int v2, int w){
            this.v1 = v1;
            this.v2 = v2;
            this.w = w; //간선의 cost
        }
        @Override
        public int compareTo(Edge o){ //간선의 cost로 오름차순 정렬
            return this.w-o.w;
        }
    }
    
    int[] parent; //parent[i]는 i 노드가 속한 집합의 부모 노드(i노드의 부모노드일 수도 있고 i노드가 속한 집합의 루트노드일 수도 있음)
    
    public int find(int v){ //노드 v가 어느 집합에 포함되어 있는지 찾는 연산. 집합의 루트노드를 반환.
        if(parent[v]<0) return v; //parent[v]<0이하일 때 v는 루트노드이므로 v를 리턴
        else return parent[v] = find(parent[v]); //본인이 루트노드가 아니라면 재귀적으로 루트를 찾아 반환해줌. 루트노드를 찾았으면 이전까지 타고 온 노드들의 부모를 모두 루트노드로 바꿔주도록 parent[v]에 저장하는 코드를 추가해 직통으로 루트노드로 가도록 해줌.(경로 압축)
    }
    
    public void union(int v1, int v2){ //노드 v1가 포함된 집합과 노드 v2가 포함된 집합을 합치는 연산
        v1 = find(v1);
        v2 = find(v2);
        if(v1!=v2){ //같은 집합이 아닐 경우에만 합집합시킴.
            if(parent[v1]<parent[v2]) parent[v2] = v1; //루트가 v1인 집합이 높이(레벨)가 더 높은 트리일 경우. (작은 트리가 큰 트리로 들어가면 높이는 변하지 않음)
            else if(parent[v1]>parent[v2]) parent[v1]=v2; //루트가 v2인 집합이 높이(레벨)가 더 높은 트리일 경우. (작은 트리가 큰 트리로 들어가면 높이는 변하지 않음)
            else{ //두 트리의 레벨이 같다면,
                parent[v1]--; //루트가 v1인 트리쪽으로 합쳐, 해당 트리의 레벨이 1 증가
                parent[v2] = v1;
            }
        }
    }
    
    public int solution(int n, int[][] costs) {
        parent = new int[n]; //parent[i]는 i 노드가 속한 집합의 부모 노드(i노드의 부모노드일 수도 있고 i노드가 속한 집합의 루트노드일 수도 있음). 노드(섬)이 n개 존재하므로 크기는 n으로 생성 
        Arrays.fill(parent, -1); //parent 배열의 값은 모두 -1로 초기화해줌(처음엔 각 노드가 루트노드이고 레벨은 한층이므로)
        ArrayList<Edge> edgeList = new ArrayList<>(); //간선들을 집어넣을 ArrayList
        for(int i=0; i<costs.length; i++){
            edgeList.add(new Edge(costs[i][0], costs[i][1], costs[i][2])); //간선들을 모두 집어넣음
        }
        int answer = 0; //다리 건설 비용 누적해나갈 변수 answer
        Collections.sort(edgeList); //간선들을 간선의 가중치 값을 기준으로 오름차순 정렬한 후, 앞에서부터 간선을 선택해 그려나감
        for(Edge e : edgeList){
            if(find(e.v1)!=find(e.v2)){ //선택한 간선에 의해 사이클이 만들어지지 않는 경우에만 해당 간선을 선택. 이미 연결된 두 정점(=같은 집합인 두 정점)을 연결하면 무조건 사이클이 생기기 때문에, Find 함수 이용하여 해당 간선의 두 정점이 같은 집합에 포함된 정점이면 그 간선은 그리지 않고, 다른 집합에 포함된 정점일 경우에만 해당 간선 선택해 Union함
                answer+=e.w; //해당 간선 선택한 것이므로 다리 건설 비용 누적
                union(e.v1, e.v2); //두 정점 연결함
            }
        }
        return answer; //answer 리턴
    }
}

/*
높이(레벨)가 더 높은 트리가 높이가 낮은 트리 밑으로 들어가게 되면 트리가 점점 깊어질 위험이
있음. 따라서 두 집합을 union할 때 트리의 높이가 낮은 트리가 높은 트리 밑으로 들어가야 하는데,
이를 위해서는 트리의 높이를 기록해두어야 함. 트리의 높이를 기억하는 rank 라는 배열을 따로
선언해주게 되면, parent 배열도 rank 배열도 존재하여 메모리를 두 배로 사용하게 됨. 따라서
parent 배열 하나로 부모노드 저장도 하고 트리의 높이도 기억하도록 코드를 수정해줌. 
- parent[x] 값이 음수이면, x는 루트 노드이고, parent[x]의 절댓값이 트리의 높이(레벨).
- parent[x] 값이 양수이면, 원래처럼 x는 자식 노드이고, parent[x]의 값이 부모 노드.
*/