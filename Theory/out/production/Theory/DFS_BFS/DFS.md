## 🔥탐색 알고리즘

### ✅ Graph

먼저 그래프의 기본 구조를 알아보면 그래프는 노드와 간선으로 표현된다. 그래프 탐색이란 하나의 노드를 시작으로 다수의 노드를 방문하는 것을 말한다. 또한 두 노드가 간선으로 연결되어 있다고 하면 두 노드는 인접하다고 표현한다.

그래프는 크게 2가지 방식으로 표현된다.

1. 인접 행렬 : 2차원 배열로 그래프의 연결 관계를 표현하는 방식
2. 인접 리스트 : 리스트로 그래프의 연결 관계를 표현하는 방식

#### 차이점

메모리 측면에서 보면 인접 행렬 방식은 모든 관계를 저장하므로 노드 개수가 많을수록 메모리가 불필요하게 낭비가된다. 하지만 리스트 방식은 연결된 데이터를 하나씩 확인하기 때문에 정보를 얻는 속도가 느리다.

### ✅ DFS

- DFS는 Depth-First-Search, 깊이 우선 탐색이라고 부르며, 그래프텡서 깊은 부분을 우선으로 탐색 하는 알고리즘이다.

DFS는 특정한 경로로 탐색하다가 특정한 상황에서 최대한 깊숙히 들어가 노드를 방문한 후, 다시 돌아가 다른 경로로 탐색하는 알고리즘이다.

1. 탐색 시작 노드는 스택에 삽입하고 방문 처리
2. 스택의 최상단 노드에 방문하지 않은 인접 노드가 있으면 그 인접 노드를 스택에 넣고 방문 처리, 방문하지 않은 인접 노드가 없으면 스택에서 최상단 노드를 꺼낸다.
3. 2번의 과정을 더 이상 수행할 수 없을 때 까지 반복한다.

![image-20220220220203386](/Users/chan/Library/Application Support/typora-user-images/image-20220220220203386.png)

### 백준 2606

~~~kotlin
import java.util.*

var n: Int = 0
var m: Int = 0
var graph = Array(101) { Array(101) { 0 } }
var visit = Array(101) { 0 }

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var a: Int
    var b: Int

    n = nextInt()
    m = nextInt()

    for (i in 0 until m) {
        a = nextInt()
        b = nextInt()
        graph[a][b] = 1
        graph[b][a] = 1
    }

    dfs(1)

    println(visit.filter { it == 1 }.size - 1)
    println(visit.toList())
}

fun dfs(x: Int) {
    visit[x] = 1
    for (i in 1..n) {
        if (visit[i] == 1 || graph[x][i] == 0) continue
        dfs(i)
    }
}
~~~

