public class NBody{
	public static double readRadius(String filename){
		In in=new In(filename);
		in.readInt();
		double Radius=in.readDouble();
		return Radius;
	}
	public static Planet[] readPlanet(String filename){
		In in=new In(filename);
		int num=in.readInt();
		Planet[] planet=new Planet[num];
		in.readDouble();
		for(int i=0;i<num;i++){
			double xP=in.readDouble();
			double yP=in.readDouble();
			double xV=in.readDouble();
			double yV=in.readDouble();
			double m=in.readDouble();
			String img=in.readString();
			planet[i]=new Planet(xP, yP, xV, yV, m, img);
		}
		return planet;
	}
	//���Ƴ�ʼ����״̬
	public static void main(String[] args){
		double T=Double.parseDouble(args[0]);
		double dt=Double.parseDouble(args[1]);
		String filename=args[2];
		double uniRadius=NBody.readRadius(filename);
		Planet[] planets=NBody.readPlanet(filename);
		//���Ʊ���
		StdDraw.setScale(-uniRadius,uniRadius);
		StdDraw.clear();
		StdDraw.picture(0,0,"images/starfield.jpg");
		//��������
		for(Planet p:planets){
			p.draw();
		}
		//����˫����
		StdDraw.enableDoubleBuffering();
		for(double time=0;time<=T;time+=dt){
			double[] xForces=new double[planets.length];
			double[] yForces=new double[planets.length];
			//����xForce��yForce
			for(int i=0;i<planets.length;i++){
				xForces[i]=planets[i].calcNetForceExertedByX(planets);
				yForces[i]=planets[i].calcNetForceExertedByY(planets);
			}
			//��xForce�����yForce����ȫ���������Ժ����update
			for(int i=0;i<planets.length;i++){
				//����ÿ������
				planets[i].update(dt,xForces[i],yForces[i]);
			}
			//���Ʊ���,��(0,0)Ϊ���ĵ㣬�������ö�
			StdDraw.picture(0,0,"images/starfield.jpg");
			for(int i=0;i<planets.length;i++){
				//����ÿ�����ǵ�ͼƬ
				planets[i].draw();
			}
			//��ʾ
			StdDraw.show();
			//��ͣʮ����
			StdDraw.pause(10);
		}
		//��ӡ����ʱ�䵽��Tʱ������״̬
		StdOut.printf("%d\n",planets.length);
		StdOut.printf("%.2e\n,uniRadius");
		for(int i=0;i<planets.length;i++){
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %12s\n",planets[i].xxPos,planets[i].yyPos,
			planets[i].xxVel,planets[i].yyVel,planets[i].mass,planets[i].imgFileName);
		}
	}
}





















