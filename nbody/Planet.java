public class Planet{
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;	//���������ǵ�ͼ�����Ӧ���ļ���
	public Planet(double xP,double yP,double xV,double yV,double m,String img){
		xxPos=xP;
		yyPos=yP;
		xxVel=xV;
		yyVel=yV;
		mass=m;
		imgFileName=img;
	}
	public Planet(Planet p){
		xxPos=p.xxPos;
		yyPos=p.yyPos;
		xxVel=p.xxVel;
		yyVel=p.yyVel;
		mass=p.mass;
		imgFileName=p.imgFileName;
	}	
	public double calcDistance(Planet p){
		double dx=this.xxPos-p.xxPos;
		double dy=this.yyPos-p.yyPos;
		double r=Math.sqrt(dx*dx+dy*dy);
		return r;
	}
	public double calcForceExertedBy(Planet p){
		double G=6.67e-11;
		double r1=calcDistance(p);
		double F=G*this.mass*p.mass/(r1*r1);
		return F;
	}
	//����x�������
	public double calcForceExertedByX(Planet p){
		double Fx=this.calcForceExertedBy(p)*(p.xxPos-this.xxPos)/this.calcDistance(p);
		return Fx;
	}
	//����y�������
	public double calcForceExertedByY(Planet p){
		double Fy=this.calcForceExertedBy(p)*(p.yyPos-this.yyPos)/this.calcDistance(p);
		return Fy;
	}
	//�����
	public double calcNetForceExertedByX(Planet[] ps){
		double FxNet=0;
		for(Planet c:ps){
			if(!this.equals(c)){
				FxNet+=this.calcForceExertedByX(c);
			}
		}
		return FxNet;
	}
	public double calcNetForceExertedByY(Planet[] ps){
		double FyNet=0;
		for(Planet c:ps){
			if(!this.equals(c)){
				FyNet+=this.calcForceExertedByY(c);
			}
		}
		return FyNet;
	}
	//������������ʩ�ӵ��������㵱ǰλ�ã��ٶȵı仯
	public void update(double dt,double fx,double fy){
		double Ax=fx/this.mass;
		double Ay=fy/this.mass;
		this.xxVel+=Ax*dt;
		this.yyVel+=Ay*dt;
		this.xxPos+=this.xxVel*dt;
		this.yyPos+=this.yyVel*dt;
	}
	//����������λ�û�������
	public void draw(){
		StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
	}
}










































