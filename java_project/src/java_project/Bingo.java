 package java_project;
import java.util.Scanner;
import java.util.ArrayList;

 
public class Bingo 
{
	private static Scanner scan;

	public static void sleep(int a)//타임 슬립
	{
		try {
			Thread.sleep(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//이케해야 뭔 1초쉰다.
	}
	
	public static int[] 숫자리스트()//숫자 랜덤으로 뽑아주는 리스트
	{
		int[] num= new int[16];
		for(int i=0;i<num.length;i++)
		{
			num[i]=(int)(Math.random()*20+1);
			if(i>0)
			{
				for(int j=0;j<i;j++)
				{
					if(num[j]==num[i])
					{
						i=i-1;
					}
				}
			}
		}
		return num;
	}
	
	public static int[] 숫자리스트_user()
	{
		int[] num_U= new int[16];
		scan = new Scanner(System.in);
		System.out.println("(1~20)");
		for(int i=0;i<16;i++)//중복,범위초과되는거 막아줘
		{
			System.out.print("입력"+(i+1)+":");
			int U_put=scan.nextInt();
			U_put=safeecode_num(U_put,i);
			num_U[i]=U_put;
			i=중복입력(i,num_U);
		}
		return num_U;
	}
	
	public static void 배열프린트(int list[])//배열을 나열해주는거
	{
		for(int i=0;i<16;i++)
		{
			if(list[i]>=10)
				System.out.print(list[i]+" ");
			else
				System.out.print(list[i]+"  ");
			if((i+1)%4==0)
			{
				System.out.println();
			}
		}
	}
	
	public static char safeecode(char inp,char a,char b,char c,char d)//안전코딩 함
	{
		scan = new Scanner(System.in);
		while (!(inp==a) && !(inp==b) && !(inp==c) && !(inp==d))
		{
			System.out.println(a+"/"+b+"만 입력해주세요.");
			System.out.print("재입력:");
			inp=scan.next().charAt(0);
		}
		return inp;
	}
	
	public static int safeecode_num(int a,int b)//숫자입력 안할시 안전코딩, 근데 언어입력하면 에러뜸..
	{
		scan = new Scanner(System.in);
		while(!(a>0 && a<21))
		{
			System.out.print("(1~20)의 숫자만 입력해주세요. 재입력"+(b+1)+":");
			a=scan.nextInt();
		}
		return a;
	}
	
	public static int safeecode_num(int a)//숫자입력 안할시 안전코딩, 근데 언어입력하면 에러뜸..
	{
		scan = new Scanner(System.in);
		while(!(a>0 && a<21))
		{
			System.out.print("(1~20)의 숫자만 입력해주세요. 재입력:");
			a=scan.nextInt();
		}
		return a;
	}
	
	public static int safeecode_bingoo(int number,int list[])//입력한게 빙고 범위에 초과될때 안전코딩
	{//요거 안됄텐데...
		scan = new Scanner(System.in);
		//int number=scan.nextInt();
		//number=safeecode_num(number);
		for(int i=0;i<16;i++)
		{
			while(list[i]!=number)
			{
				System.out.print("오류...빙고판 숫자를 입력하세요!"+"\n"+"재입력:");
				number=scan.nextInt();
			}
		}
		return number;
	}
	
	public static String name_in()
	{
		System.out.print("이름을 입력하세요:");
		scan = new Scanner(System.in);
		String name=scan.nextLine();//정수는 nextInt() 문자열은 next() or nextLine()
		return name;
	}
	
	public static void name_out(String a)
	{
		System.out.println("반갑습니다! "+a+"님!");
	}
	
	public static void describeRule()
	{
		System.out.print("게임의 룰을 아나요??(y/n):");
		scan = new Scanner(System.in);
		char in=scan.next().charAt(0);//char형을 받을때는 이렇게 써
		in=safeecode(in,'y','Y','n','N');
		if((in=='N') || (in=='n'))//char은 '',String은 ""
		{
			System.out.println("BINGO란 여러 종류로 배열된 각자의 숫자 카드에서 참여가 임의로 선택하여 부르는 숫자를 일치시켜"
							+"\n"+"가장 빨리 가로, 세로, 사선으로 빨리 연결하는 게임이다");
		}
		else if((in=='Y') || (in=='y'))
		{
			System.out.println("게임방법을 아시는군요!");
		}
	}
	
	public static char auto_input()
	{
		System.out.println("자동입력하실려면 a, 수동입력 하실려면 m을 입력하세요.");
		System.out.print("자동완성(a),수동입력(m):");
		scan = new Scanner(System.in);
		char in=scan.next().charAt(0);
		in=safeecode(in,'a','A','m','M');
		return in;
	}
	
	public static void describeinput()
	{
		System.out.println("입력은 이런 순서로...");
		String[][] desin=new String[4][7];
		for(int k=0;k<4;k++)
		{	
			for(int i=1;i<=5;i+=2)
			{
				desin[k][i]="~>";
			}
		}
		int cou=1;
		for(int a=0;a<4;a++)
		{
			for(int b=0;b<=6;b+=2)
			{
				String cou2 = new Integer(cou).toString();//이케 하면 전환 된다!!(인티져를 스트링으로 바꾸기)이거 강조
				desin[a][b]=cou2;
				cou+=1;
			}
		}
		for(int y=0;y<4;y++)
		{
			for(int z=0;z<7;z++)
			{
				System.out.print(desin[y][z]);
			}
			System.out.println();
		}
		
	}
	
	public static int 중복입력(int i,int list[])
	{
		if(i>0)
		{
			for(int j=0;j<i;j++)
			{
				if(list[j]==list[i])
				{
					System.out.println((j+1)+"번과 중복된 숫자 입력!"+(i+1)+"번 다시 입력");//이거 강조
					i=i-1;
				}
			}
		}
		return i;
	}
	
	public static void bingo_descri()
	{
		System.out.println("빙고게임을 시작합니다.");
		System.out.println("플레이어부터 시작,세줄완성이 빙고,숫자가 일치하면 0으로 바뀜");
	}
	
	public static void bingo_show(int list[],int list2[])
	{
		System.out.print("자신 빙고판을 보려면 y를 입력하고 아니면 아무거나 누르세요:");
		char show=scan.next().charAt(0);//이거 왜 스트링으로 하면 안돼냐ㅑ
		if(show=='y' || show=='Y')
		{
			System.out.println("유저");
			배열프린트(list);
		}
		if(show=='b')
		{
			System.out.println("유저");
			배열프린트(list);//시험판
			System.out.println("처음");
			배열프린트(list2);
		}
	}
	
	public static int cooo(int a,int b,int[] list)
	{
		while(true)
		{
			int c=0;
			for(int i=0;i<a;i++)
			{
				if(b==list[i])
				{
					b=(int)(Math.random()*15);
				}
				else
					c+=1;
			}
			if(c==a)
				break;
		}//이거랜덤으로 뽑아주는데 중복되는 인덱스 찾아줘ㅓ
		return b;
	}
	
	public static boolean bingocheck(int list[],int bingo_count,String t)
	{
		int[] bingo_line_x=new int[4];//가로 탐색
		int[] bingo_line_y=new int[4];//세로 탐색
		int[] bingo_line_r=new int[2];//대각선 탐색
		boolean booo=false;//break 조건 해주는 논리
		int count=0;
		for(int j=0;j<bingo_line_x.length;j++)//x열 빙고 검사
		{
			for(int i=count;i<count+4;i++)
			{
				bingo_line_x[j]=bingo_line_x[j]+list[i];
			}
			count+=4;
			if(bingo_line_x[j]==0)
			{
				bingo_count+=1;
			}
		}
		count=0;
		for(int a=0;a<bingo_line_y.length;a++)
		{
			for(int b=count;b<count+13;b=b+4)
			{
				bingo_line_y[a]=bingo_line_y[a]+list[b];
			}
			count+=1;
			if(bingo_line_y[a]==0)
			{
				bingo_count+=1;
			}
		}
		for(int g=0;g<16;g=g+5)
			bingo_line_r[0]=bingo_line_r[0]+list[g];
		for(int k=3;k<13;k=k+3)
			bingo_line_r[1]=bingo_line_r[1]+list[k];
		for(int aa=0;aa<2;aa++)
		{
			if(bingo_line_r[aa]==0)
				bingo_count+=1;
		}
		System.out.println(t+"의 현재 빙고 수:"+bingo_count);
		if(bingo_count==3)
		{
			System.out.println("-----"+t+": 3 BINGO!!"+t+"WIN-----");
			booo=true;
		}
		return booo;
		
	}
	public static void catego()
	{
		char inp;
		boolean boo_U=false;
		boolean boo_C=false;
		int[] num_C= new int[16];//컴퓨터 빙고
		int[] num_U= new int[16];//플레이어 빙고
		System.out.println("숫자범위는 (1~20)");
		inp=auto_input();
		if((inp=='a') || (inp=='A'))
		{
			num_U=숫자리스트();
			배열프린트(num_U);
			System.out.println("---빙고판 완성---");
		}
		else if((inp=='m') || (inp=='M'))
		{
			describeinput();
			num_U=숫자리스트_user();
			System.out.println("---빙고판 완성---");
			배열프린트(num_U);
		}
		bingo_descri();
		boolean turn=true;
		int[] num_c_중복 = new int[16];
		for(int k=0;k<16;k++)
			num_c_중복[k]=-1;//리스트전체를 아무값도 없게 해주기 위해
		ArrayList<Integer> show_list=new ArrayList<Integer>();//이케 해줘야 add매소드 쓸수있음
		//show_list는 입력한 숫자를 저장해서 위에다 보여주는것 이건 지워졌다는 의미
		num_C=숫자리스트();
		//배열프린트(num_C);//나중에 지워
		int count=0;
		int[] test=num_U;//이거는 처음의  빙고판 보여주는거 이거 왜 안돼냐
		while(true)
		{
			int bingo_cnt_U=0;
			int bingo_cnt_C=0;
			bingo_show(num_U,test);
			if(turn==true)
			{
				sleep(2000);
				System.out.print("사용된 숫자:");
				System.out.println(show_list);
				System.out.print("플레이어 입력:");
				int input16=scan.nextInt();
				show_list.add(input16);
				for(int i=0;i<16;i++)
				{
					if(num_U[i]==input16)
					{
						num_U[i]=0;
						System.out.println("유저");
						배열프린트(num_U);
					}
				}
				for(int i=0;i<16;i++)
				{
					if(num_C[i]==input16)
					{
						num_C[i]=0;
						//System.out.println("컴터");
						//배열프린트(num_C);
						num_c_중복[count]=i;
						count+=1;//이것도 컴퓨터 중복에 포함해야돼
					}
				}
				boo_U=bingocheck(num_U,bingo_cnt_U,"사용자");
				boo_C=bingocheck(num_C,bingo_cnt_C,"컴퓨터");//비기는 조건있어야 할텐데 나중에 ㄱ
				if(boo_U || boo_C)
				{
					if(boo_C==true) 
					{
						System.out.println("컴터");
						배열프린트(num_C);
					}
					break;
				}
				turn=false;
			}
			if(turn==false)//컴퓨터 차례
			{
				sleep(1000);
				System.out.println("컴퓨터 차례");
				sleep(1000);
				int input_com=(int)(Math.random()*15);
				input_com=cooo(count,input_com,num_c_중복);
				System.out.println("컴퓨터 입력:"+num_C[input_com]);
				num_c_중복[count]=input_com;
				show_list.add(num_C[input_com]);
				for(int i=0;i<16;i++)
				{
					if(num_U[i]==num_C[input_com])
					{
						num_U[i]=0;
						System.out.println("유저");
						배열프린트(num_U);
					}
				}
				for(int i=0;i<16;i++)
				{
					if(num_C[i]==num_C[input_com])
					{
						num_C[i]=0;
						//System.out.println("컴터");
						//배열프린트(num_C);
					}
				}
				boo_U=bingocheck(num_U,bingo_cnt_U,"사용자");
				boo_C=bingocheck(num_C,bingo_cnt_C,"컴퓨터");
				if(boo_U || boo_C)
				{
					if(boo_C==true) 
					{
						System.out.println("컴터");
						배열프린트(num_C);
					}
					break;
				}
				turn=true;
				count+=1;
			}
		}
	}
	
	public static void main(String[] args) 
	{
		scan = new Scanner(System.in);
		System.out.println("-----------BINGO-----------");
		String name1=name_in();
		name_out(name1);
		describeRule();
		System.out.println("-----------START-----------");
		catego();
	}

}
