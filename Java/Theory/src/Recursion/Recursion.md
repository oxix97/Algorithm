# Algorithm_Theory

### Recursion ?

자기 자신을 호출하는 함수라고 한다.

<div id = "Inroof"> 예시 </div>

~~~java
public class Inroof{
    public static void main(String[] args) {
        func();
    }
    public static void func(){
        System.out.println("Hello");
        func();
    }
}
~~~

이렇게 자기 자신을 호출하는 것을 순환 (Recursion) 이라고 한다.

앞선 [코드](#inroof)는 무한루프이다. 그렇다면 순환은 항상 무한루프에 빠질까? <br>
그렇지 않다 종료 조건을 걸면 쉽게 빠져나올수 있다.

<div id = "outroof"> 예시</div>

~~~java
public class outroof{
    public static void main(String[] args) {
        func(4);
    }

    public static void func(int n) {
        if (n <= 0) {
            return;
        } else {
            System.out.println("World!");
            func(n-1);
        }
    }
}
~~~

#### 결과

>World! <br>
World! <br>
World! <br>
World!

총 4번 실행이 되었는데 다음과 같이 실행되었다. <br>
func(4) -> func(3) -> func(2) -> func(1) -> func(0) -> if 조건문을 만나 return;

#### 그럼 무한루프에 빠지지 않으려면 어떻게 해야 할까?

- 적어도 하나의 recursion 에 빠지지 않는 경우가 존재해야 한다.
- recursion 을 반복하다보면 종료 조건으로 수렴해야 한다.

위의 [코드](#outroof)에 해당 코드를 추가해보자.
~~~java
public static int func2(int n){
    if (n <= 0) {
        return 0;
    }else{
        return n + func2(n-1);
    }
}
~~~

실행결과는 어떻게 될까? <br>
답은 10이다. 

실행 순서는 result 에 값 대입할 때 func2(4) 호출이 되고 순환을 시작한다.
실행 순서는 이전에 결과랑 같으며 순환이 다 끝난 이후에 result 에 대입한다.

---
### 순환함수와 수학적 귀납법

정리 : func2(int n)은 음이 아닌 정수 n에 대하여 0에서 n 까지의 합을 계산한다.

1. n=0 -> 0을 반환하게 된다.
2. 0 < k = n 인 경우 func2(k)는 먼저 func2(k-1) 호출한다. 이 과정에서 0부터 k-1 까지 더하며 func2는 그 값에 k 를 더해 반환한다.

이와 비슷한 예를 들면

---
#### 팩토리얼

~~~java
public static int factorial (int n) {
    if (n == 0) {
        return 1;
    } else {
        return n * factorial(n-1);
    }
}
~~~

---
#### n의 k 제곱 구하기

~~~java
    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * power(x,n-1);
        }
    }

~~~

---
#### 피보나치 함수

~~~java
    public static int fibonacci(int n) {
        if (n < 1) {
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
~~~

---
#### 최대 공약수 ver.1

~~~java
    public static int gcd(int m, int n) {
        int max = Math.max(m,n);
        int min = Math.min(m,n);
        if (max % min == 0) {
            return min;
        } else {
            return gcd(min, max % min);
        }
    }
~~~

#### 실행과정

max  = m , min = n 으로 지정해놓고 max % min ==0 이면 min 이 최대 공약수가 되는 것이다. <br>
m = 10, n = 4 -> max = 10 , min = 4 -> else 조건 만족하여 gcd(4,2) <br>
max = 4, min = 2 if 조건 만족하여 return min; -> 최대 공약수는 2가 되는 것 이다.

---
#### 최대 공약수 ver.2

~~~java
    public static int sampleGcd(int p, int q) {
        if (q == 0) {
            return p;
        }else{
            return sampleGcd(q,p%q);
        }
    }
~~~

#### 실행과정

ver.1 과 같은 최대 공약수 구하는 순환 이다. <br>
ver.1 와는 다르게 대_소 관계를 정하지 않아도 되며 반복 하면서 0에 수렴하게 된다. <br>
대소 관계를 정하지 않고 간편한 대신에 수가 커지는 만큼 반복 회수 차이도 난다.

---
지금까지는 순환은 수학적으로 사용을 했지만 실은 그렇지 않은 경우도 많다. 실생활에 사용하는 함수 역시 순환으로 표현이 가능하다.

#### 문자열의 길이 계산

~~~java
public static int length(String str) {
    if(str.equals("")) return 0;
    
    else return 1 + length(str.substring(1));
}
~~~

#### 문자열의 프린트

~~~java
public static void printChars(String str) {
    if (str.length() == 0) {
        return;
    } else {
        System.out.print(str.charAt(0));
        printChars(str.substring(1));
    }
}
~~~

#### 문자열 뒤집기

~~~java
public static void printCharsReverse(String str) {
    if (str.length() == 0) {
        return;
    } else {
        printCharsReverse(str.substring(1));
        System.out.print(str.charAt(0));
    }
}
~~~

---

#### 순환문 vs 반복문

위의 코드들은 모두 반복문으로 구현이 가능하며 그 역의 경우 역시 성립한다. <br>

**장점 :** 복잡한 알고리즘을 단순하고 알기쉽게 표현하는 것을 가능하게 한다.

**단점 :** 함수 호출에 따른 오버헤드가 있다. (매개변수 전달, 엑티베이션 프레임 생성 등등)

---

#### 순차 탐색 (반복문) 
조건 : 0 < n < arr.length
~~~java
public static int search(int[] arr, int n, int target) {
    for (int i = 0; i < n; i++) {
        if(arr[i] == target) return i;
    }
    return -1;
}
~~~

#### 순차탐색 (순환)

~~~java
public static int search(int[] arr, int begin, int end, int target) {
    if (begin > end) {
        return -1;
    } else if (target == arr[begin]) {
        return begin;
    } else {
        return search(arr, begin + 1, end, target);
    }
}
~~~

#### 이진검색 (순환)

~~~java
 public static int BinarySearch(String[] arr, String target, int begin, int end) {
    if (begin > end) {
        return -1;
    } else {
        int mid = (begin + end) / 2;
        int result = target.compareTo(arr[mid]);
        
        if (result == 0) {
            return mid;
        } else if (result < 0) {
            return BinarySearch(arr, target, begin, mid - 1);
        } else {
            return BinarySearch(arr, target, mid + 1, end);
        }
    }
}
~~~
