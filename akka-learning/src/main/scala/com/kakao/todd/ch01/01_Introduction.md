# Introduction to Akka

scalable, resilient한 시스템을 개발하기 위해 제공되는 라이브러리 셋. Akka를 사용하면 reliable, fault tolerance, high performance 를 위한
low-level 코드를 작성하는 것보다 비즈니스에 집중한 코드를 작성할 수 있을 것이다.

Akka를 이용하면 다음과 같은 것들을 해결할 수 있다.

- atomic이나 lock과 같은 로우레벨의 동시성을 구축하지 않고도 멀티스레드 프로그래밍를 할 수 있다. - memory visibility, barrier 이슈에 대해서도 신뢰할 수 있다.
- 시스템과 컴포넌트간은 투명한 커뮤니케이션을 제공한다. - 어려운 네트워킹 코드를 코드를 작성하거나 유지하지 않아도 된다.
- 필요에 따라 elastic하게 스케일 인 아웃을 수행할 수 있는 클러스터된 고가용성 아키텍처를 제공한다. - 진정한 reactive 시스템을 구축할 수 있다.  



