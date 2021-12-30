# 자바 ORAM 표준 JPA 프로그래밍 정리


## 개발 환경에 따른 DDL 전략
개발 초기 단계는 create 또는 update
초기화 상태로 자동화된 테스트를 진행하는 개발자 환경과 CI 서버는 create 또는 create-drop
테스트 서버는 update 또는 validate
스테이징과 운영 서버는 validate 또는 none
