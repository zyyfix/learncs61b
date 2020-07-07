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
	//绘制初始宇宙状态
	public static void main(String[] args){
		double T=Double.parseDouble(args[0]);
		double dt=Double.parseDouble(args[1]);
		String filename=args[2];
		double uniRadius=NBody.readRadius(filename);
		Planet[] planets=NBody.readPlanet(filename);
		//绘制背景
		StdDraw.setScale(-uniRadius,uniRadius);
		StdDraw.clear();
		StdDraw.picture(0,0,"images/starfield.jpg");
		//绘制行星
		for(Planet p:planets){
			p.draw();
		}
		//动画双缓冲
		StdDraw.enableDoubleBuffering();
		for(double time=0;time<=T;time+=dt){
			double[] xForces=new double[planets.length];
			double[] yForces=new double[planets.length];
			//计算xForce和yForce
			for(int i=0;i<planets.length;i++){
				xForces[i]=planets[i].calcNetForceExertedByX(planets);
				yForces[i]=planets[i].calcNetForceExertedByY(planets);
			}
			//在xForce矩阵和yForce矩阵全都生成了以后才能update
			for(int i=0;i<planets.length;i++){
				//更新每个星体
				planets[i].update(dt,xForces[i],yForces[i]);
			}
			//绘制背景,以(0,0)为中心点，背景不用动
			StdDraw.picture(0,0,"images/starfield.jpg");
			for(int i=0;i<planets.length;i++){
				//绘制每个行星的图片
				planets[i].draw();
			}
			//显示
			StdDraw.show();
			//暂停十毫秒
			StdDraw.pause(10);
		}
		//打印最终时间到达T时的宇宙状态
		StdOut.printf("%d\n",planets.length);
		StdOut.printf("%.2e\n,uniRadius");
		for(int i=0;i<planets.length;i++){
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %12s\n",planets[i].xxPos,planets[i].yyPos,
			planets[i].xxVel,planets[i].yyVel,planets[i].mass,planets[i].imgFileName);
		}
	}
}





















