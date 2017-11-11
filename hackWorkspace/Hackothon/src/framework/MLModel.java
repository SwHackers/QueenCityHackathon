package framework;

import java.util.ArrayList;
import java.util.Map;

import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.KNearestNeighbors;
import net.sf.javaml.classification.evaluation.EvaluateDataset;
import net.sf.javaml.classification.evaluation.PerformanceMeasure;
import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.clustering.KMeans;
import net.sf.javaml.clustering.evaluation.ClusterEvaluation;
import net.sf.javaml.clustering.evaluation.SumOfSquaredErrors;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.DefaultDataset;
import net.sf.javaml.core.DenseInstance;
import net.sf.javaml.core.Instance;

public class MLModel
{	
	public MLModel(double[][] data)
	{		
		double[][] columns = new double[15][100];
		
		for (int r = 0; r < data.length; r++)
		{
			for (int c = 0; c < data[r].length; c++)
			{
				columns[c][r] = data[r][c];
			}
		}
		
		for (int c = 0; c < columns.length; c++)
		{
			//System.out.println("Begin loop, c = " + c);
			
			Instance instance = new DenseInstance(columns[c]);
			
			Dataset set = new DefaultDataset();
			Dataset comp = set;
			
			Classifier knn = new KNearestNeighbors(5);
			knn.buildClassifier(set);
			
			int correct = 0, wrong = 0;
			
		    Object predictedClassValue = knn.classify(instance);
		    Object realClassValue = instance.classValue();
		    if (predictedClassValue.equals(realClassValue))
		        correct++;
		    else
		        wrong++;
			
			System.out.println(correct);
			
//			for (int i = 0; i < columns[c].length; i++)
//			{
//				set.add(i, instance);
//			}
//			
//			Clusterer km = new KMeans(1);
//			
//			Dataset[] clusters = km.cluster(set);
//			
//			ClusterEvaluation sse = new SumOfSquaredErrors();
//			
//			double score = sse.score(clusters);
//			System.out.println("Score = " + score);
		}
	}
}
