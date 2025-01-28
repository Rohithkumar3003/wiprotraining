package com.wiprobasic2;

public class Mathematics {
		static void add(int a,int b) {
			int c=a+b;
			System.out.println(c);
		}
		static int sub(int d,int e) {
			return d-e;
		}
		void mul(int g,int h) {
			int k=g*h;
			System.out.println(k);
			
		}
		double div(int m,int n) {
			return m/n;
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
		
			Mathematics a1=new Mathematics();
		    a1.mul(20, 12);
		    
			double res2=a1.div(35,8);
			System.out.println(res2);
			
			int res=sub(15,36);
			System.out.println(res);
			
			add(29,42);
		}

	}
