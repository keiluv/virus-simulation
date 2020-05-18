import java.util.Random;
import java.util.Scanner;
import java.util.Random;

//코로나 바이러스 클래스
class Corona{
    //은닉화
    private String confirmatorName;//첫 확진자 명 변수
    private int confirmatorNum;//확진자 수 변수
    private String country;//확진 국가 변수

    //첫 확진자 접근 set메서드
    public void setName(String confirmatorName){
        this.confirmatorName = confirmatorName;
    }
    //확진자 수 접근 set메서드
    public void setCnum(int confirmatorNum){
        this.confirmatorNum = confirmatorNum;
    }

    //확진 국가 접근 set메서드
    public void setCountry(String country){
        this.country = country;
    }

    public String getName(){
        return confirmatorName;
    }   
    public int getCnum(){
        return confirmatorNum;
    }
    public String getCountry(){
        return country;
    }

    //확진자 수 증가 메서드
    public void increase(){
        confirmatorNum++;
    }
    //코로나 클래스 입력 메서드
    public Corona(String country, String confirmatorName, int confirmatorNum){
        this.country = country;
        this.confirmatorName = confirmatorName;
        this.confirmatorNum = confirmatorNum;
        
    }
    
    
}

class Main {
    public static void main(String[] args) {
        System.out.println("코로나 바이러스 데이터!");
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        
        //배열 객체 생성
        Corona[] c = new Corona[5];//클래스 객체 배열
        String[] country = new String[5];//국가 변수 배열
        String[] name = new String[5];//확진자명 변수 배열
        int[] patient = new int[5];//확진자수 변수 배열

        //반복문
        for(int i = 0;i<5;i++){
            System.out.println("국가를 입력하시오");
            country[i]= scan.next();//국가명 입력
            System.out.println("첫 확진자 이름을 입력하시오.");
            name[i]=scan.next();//확진자명 입력
            System.out.println("확진자 수를 입력하시오.");    
            patient[i] = scan.nextInt();//확진자 수 입력
        }

        for(int i = 0 ;i<5;i++){
            //입력받은 배열 값을 클래스에 저장
            c[i] = new Corona(country[i],name[i],patient[i]); 
        }
        
        //현재 코로나 상태 출력
        for(int i = 0;i<5;i++){
            System.out.println("해당국가: "+c[i].getCountry());
            System.out.println("첫 확진자명: "+c[i].getName());
            System.out.println("확진자수: "+c[i].getCnum());
        }

        System.out.println("확진자 추가 발생! 확진자의 접촉대상 증가로 확진자가 늘어났습니다.");

        //각 나라당 확진자 수를 범위로 지정한 뒤 그 안에서 랜덤 값으로 확진자 수를 코로나 클래스 안의 increase()메서드를 반복하는 방법을 통해 더함.
        for(int i = 0;i<5;i++){
            for(int j =0;j<random.nextInt(c[i].getCnum()+1) ;j++){
                c[i].increase();
            }
        }

        //위의 코로나 상태와 비교
        for(int i = 0;i<5;i++){
            System.out.println("해당국가: "+c[i].getCountry());
            System.out.println("첫 확진자명: "+c[i].getName());
            System.out.println("확진자수: "+c[i].getCnum());
        }

        scan.close();
    }
}