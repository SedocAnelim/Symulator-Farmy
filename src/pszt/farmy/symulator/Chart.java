package pszt.farmy.symulator;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.*;

/**
 * Created by Milena on 01-05-2017
 */

public class Chart{
	
	public static void display (List<DoubleSummaryStatistics> dataList){
		Stage window = new Stage();
		
		window.setTitle("Chart");
		final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Generation");
        //yAxis.setLabel("labelName");
        
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Line Chart");
        //defining data series
        XYChart.Series fitnessSeries = new XYChart.Series();
        fitnessSeries.setName("Fitness");
        XYChart.Series averageSeries = new XYChart.Series();
        averageSeries.setName("Average");
        
		StackPane layout = new StackPane();
		layout.getChildren().add(lineChart);
		Scene scene = new Scene(layout, 600, 400);
		window.setScene(scene);
		window.show();
		 
		//filling in with data
		for(int i = 0; i < dataList.size(); i=i+5){
		      fitnessSeries.getData().add(new XYChart.Data(i, dataList.get(i).getMax()));
		      averageSeries.getData().add(new XYChart.Data(i, dataList.get(i).getAverage()));
	    }
	    lineChart.getData().add(fitnessSeries);
	    lineChart.getData().add(averageSeries);
	}
	
}
