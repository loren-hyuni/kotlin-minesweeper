# kotlin-minesweeper

## 지뢰 찾기 (그리기)

### 기능 요구 사항
- [x] 높이와 너비, 지뢰 개수를 입력받을 수 있다.
- [x] 지뢰는 눈에 잘 띄는 것으로 표기한다
- [x] 지뢰는 랜덤에 가깝게 배치한다.
- [x] 한 메서드에 오직 한 단계의 들여쓰기만 한다.
- [x] else 예약어를 쓰지 않는다.
- [x] 모든 원시값과 문자열을 포장한다.
- [x] 한 줄에 점을 하나만 찍는다.
- [x] 줄여 쓰지 않는다. (축약 금지)
- [x] 모든 엔티티를 작게 유지한다.
- [x] 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
- [x] Getter/Setter/Properties를 쓰지 않는다.
- [x] 일급 콜렉션을 쓴다.

## 지뢰 찾기 (지뢰 개수)

### 기능 요구 사항
- [x] 각 사각형에 표시될 숫자가 표시될 수 있다.
- [x] 표시된 숫자는 자신을 제외한 주변 8개에 포함된 지뢰 수이다.

## 지뢰 찾기 (게임 실행)

### 기능 요구 사항
- [x] 사용자가 open할 지점을 선택한다.
- [x] 지뢰가 없는 인접한 칸이 모두 열린다.
- [x] 지뢰를 밟으면 게임이 종료된다.
- [x] 지뢰를 모두 찾으면 게임을 승리한다?