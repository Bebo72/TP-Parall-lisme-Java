package polytech.tours.di.parallel.td3.pi;

public class Tester {

	public static void main(String[] args) {
		
		//experimental set up
		long runs[] = {1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000, 1_000_000_000};
		int tasks[]={1, 10, 100, 1_000};
		int threads[]={1, 10, 20, 50, 100};
		
		System.out.println("RUNS\tTASKS\tTHREADS\tCPU\tPI");
		for(int r=0;r<runs.length;r++){
			for(int t=0; t<tasks.length; t++){
				for(int p=0; p<threads.length; p++){
					//experiment
					PICalculator calculator=new PICalculator();
					long start=System.currentTimeMillis();
					double pi=calculator.computePI(runs[r], threads[p], tasks[t]);
					long end=System.currentTimeMillis();
					System.out.println(runs[r]+"\t"+tasks[t]+"\t"+threads[p]+"\t"+(end-start)/1000d+"\t"+pi);
				}
			}
		}
	}

}
