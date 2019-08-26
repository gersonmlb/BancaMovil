package itsight.bancamovil.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.CandleStickChart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleDataSet;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import itsight.bancamovil.R;
import itsight.bancamovil.common.BaseFragment;

public class EstaditicaFragment extends BaseFragment {

    private LineChart cht_Grafico_01;

    private BarChart cht_Grafico_021;
    private HorizontalBarChart cht_Grafico_022;

    private BarChart cht_Grafico_023;

//    private BarLineChartBase cht_Grafico_03;
    private BubbleChart cht_Grafico_03;
    private CombinedChart cht_Grafico_04;

    private CandleStickChart cht_Grafico_05;

    private PieChart cht_Grafico_06;

    private RadarChart cht_Grafico_07;

    public static EstaditicaFragment newInstance() {
        EstaditicaFragment estaditicaFragment = new EstaditicaFragment();
        return estaditicaFragment;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_estadistica;
    }

    @Override
    public boolean hasOptionsMenuEnable() {
        return false;
    }

    @Override
    protected void setupView(View view) {

        Grafico_01(view);

        Grafico_02(view);

        Grafico_023(view);

        Grafico_03(view);

        Grafico_04(view);

        Grafico_05(view);

        Grafico_06(view);

        Grafico_07(view);
    }

    @Override
    protected void onRestoreView(Bundle savedInstanceState) {

    }

    private void Grafico_07(View view) {
        cht_Grafico_07 = (RadarChart) view.findViewById(R.id.cht_Grafico_07);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(4f, 0));
        entries.add(new Entry(5f, 1));
        entries.add(new Entry(2f, 2));
        entries.add(new Entry(7f, 3));
        entries.add(new Entry(6f, 4));
        entries.add(new Entry(5f, 5));

        ArrayList<Entry> entries2 = new ArrayList<>();
        entries2.add(new Entry(1f, 0));
        entries2.add(new Entry(5f, 1));
        entries2.add(new Entry(6f, 2));
        entries2.add(new Entry(3f, 3));
        entries2.add(new Entry(4f, 4));
        entries2.add(new Entry(8f, 5));

        RadarDataSet dataset_comp1 = new RadarDataSet(entries, "Company1");
        RadarDataSet dataset_comp2 = new RadarDataSet(entries2, "Company2");


        dataset_comp1.setColor(Color.CYAN);
        dataset_comp2.setColor(Color.RED);

        dataset_comp1.setDrawFilled(true);
        dataset_comp2.setDrawFilled(true);


        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Communication");
        labels.add("Technical Knowledge");
        labels.add("Team Player");
        labels.add("Meeting Deadlines");
        labels.add("Problem Solving");
        labels.add("Punctuality");

        ArrayList<IRadarDataSet> dataSets = new ArrayList<IRadarDataSet>();

        dataSets.add(dataset_comp1);
        dataSets.add(dataset_comp2);

        RadarData data = new RadarData(labels, dataSets);

        cht_Grafico_07.setData(data);

        String description = "Employee-Skill Analysis (scale of 1-10), 10 being the highest";
        cht_Grafico_07.setDescription(description);
        cht_Grafico_07.setWebLineWidthInner(0.5f);
        cht_Grafico_07.setDescriptionColor(Color.RED);

//        cht_Grafico_07.invalidate(); // Refrescar Data

//        cht_Grafico_07.animate(); // Animacion
    }

    private void Grafico_06(View view) {
        cht_Grafico_06 = (PieChart) view.findViewById(R.id.cht_Grafico_06);

        // creating data values
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(4f, 0));
        entries.add(new Entry(8f, 1));
        entries.add(new Entry(6f, 2));
        entries.add(new Entry(12f, 3));
        entries.add(new Entry(18f, 4));
        entries.add(new Entry(9f, 5));

        PieDataSet dataset = new PieDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        PieData data = new PieData(labels, dataset); // initialize Piedata
        cht_Grafico_06.setData(data); //set data into chart

        cht_Grafico_06.setDescription("Description");  // set the description

//        dataset.setColors(ColorTemplate.COLORFUL_COLORS); // set the color

//        cht_Grafico_06.animateY(5000); // Animacion
    }

    private void Grafico_05(View view) {
        cht_Grafico_05 = (CandleStickChart) view.findViewById(R.id.cht_Grafico_05);


        ArrayList<CandleEntry> entries = new ArrayList<>();

        entries.add(new CandleEntry(0, 4.62f, 2.02f, 2.70f, 4.13f));
        entries.add(new CandleEntry(1, 5.50f, 2.70f, 3.35f, 4.96f));
        entries.add(new CandleEntry(2, 5.25f, 3.02f, 3.50f, 4.50f));
        entries.add(new CandleEntry(3, 6f,    3.25f, 4.40f, 5.0f));
        entries.add(new CandleEntry(4, 5.57f, 2f,    2.80f, 4.5f));

        CandleDataSet dataset = new CandleDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        CandleData data = new CandleData(labels, dataset);
        cht_Grafico_05.setData(data);


//        dataset.setColors(ColorTemplate.COLORFUL_COLORS); // Colores


//        cht_Grafico_05.setDescription("Radar Chart"); // Descripcion

//        cht_Grafico_05.animateY(5000); // Animacion
    }

    private void Grafico_03(View view) {
        cht_Grafico_03 = (BubbleChart) view.findViewById(R.id.cht_Grafico_03);


        // creating list of entry values
        ArrayList<BubbleEntry> entries = new ArrayList<>();
        entries.add(new BubbleEntry(1,50f,5f));
        entries.add(new BubbleEntry(2,10f, 5f));
        entries.add(new BubbleEntry(3,30f ,1f));
        entries.add(new BubbleEntry(4,20f, 2f));
        entries.add(new BubbleEntry(5,15f, 4f));

        BubbleDataSet dataset = new BubbleDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Jan");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        BubbleData data = new BubbleData(labels, dataset);
        cht_Grafico_03.setData(data); // set the data and list of lables into chart

        cht_Grafico_03.setDescription("Description");  // set the description


//        dataset.setColors(ColorTemplate.COLORFUL_COLORS); // Colores

//        cht_Grafico_03.animateY(5000); // Animacion
    }

    private void Grafico_04(View view) {
        cht_Grafico_04 = (CombinedChart) view.findViewById(R.id.cht_Grafico_04);

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("JAN");
        labels.add("FEB");
        labels.add("MAR");
        labels.add("APR");
        labels.add("MAY");
        labels.add("JUN");


        CombinedData data = new CombinedData(labels);

//        public LineData lineData(){
        ArrayList<Entry> line = new ArrayList<>();
        line.add(new Entry(2f, 0));
        line.add(new Entry(4f, 1));
        line.add(new Entry(3f, 2));
        line.add(new Entry(6f, 3));
        line.add(new Entry(9f, 4));
        line.add(new Entry(4f, 5));

        LineDataSet lineDataSet = new LineDataSet(line, "Brand 2");
        lineDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        LineData lineData = new LineData(labels, lineDataSet);
//            return lineData;

//        }
        // this method is used to create data for Bar graph
//        public BarData barData(){

        ArrayList<BarEntry> group1 = new ArrayList<>();
        group1.add(new BarEntry(4f, 0));
        group1.add(new BarEntry(8f, 1));
        group1.add(new BarEntry(6f, 2));
        group1.add(new BarEntry(12f, 3));
        group1.add(new BarEntry(18f, 4));
        group1.add(new BarEntry(9f, 5));

        BarDataSet barDataSet = new BarDataSet(group1, "Brand 1");
        //barDataSet.setColor(Color.rgb(0, 155, 0));
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        BarData barData = new BarData(labels, barDataSet);
//            return barData;

//        }
//        CombinedData data = new CombinedData(labels);
        data.setData(barData);
        data.setData(lineData);
        cht_Grafico_04.setData(data);
    }

    private void Grafico_023(View view) {
        cht_Grafico_023 = (BarChart) view.findViewById(R.id.cht_Grafico_023);

        // create BarEntry for group 1
        ArrayList<BarEntry> group1 = new ArrayList<>();
        group1.add(new BarEntry(4f, 0));
        group1.add(new BarEntry(8f, 1));
        group1.add(new BarEntry(6f, 2));
        group1.add(new BarEntry(12f, 3));
        group1.add(new BarEntry(18f, 4));
        group1.add(new BarEntry(9f, 5));

// create BarEntry for group 1
        ArrayList<BarEntry> group2 = new ArrayList<>();
        group2.add(new BarEntry(6f, 0));
        group2.add(new BarEntry(7f, 1));
        group2.add(new BarEntry(8f, 2));
        group2.add(new BarEntry(12f, 3));
        group2.add(new BarEntry(15f, 4));
        group2.add(new BarEntry(10f, 5));

        BarDataSet barDataSet1 = new BarDataSet(group1, "Brand 1");  // creating dataset for group1
//barDataSet1.setColor(Color.rgb(0, 155, 0));
        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);

        BarDataSet barDataSet2 = new BarDataSet(group2, "Brand 2"); // creating dataset for group1
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

//        ArrayList<BarDataSet> dataSets = new <BarDataSet>ArrayList<BarDataSet>();  // combined all dataset into an arraylist
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();  // combined all dataset into an arraylist
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);


        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");


//        BarData data = new BarData(labels, dataSets2); // initialize the Bardata with argument labels and dataSet
        BarData data = new BarData(labels, dataSets); // initialize the Bardata with argument labels and dataSet
        cht_Grafico_023.setData(data);

    }

    private void Grafico_02(View view) {
        cht_Grafico_021 = (BarChart) view.findViewById(R.id.cht_Grafico_021);
        cht_Grafico_022 = (HorizontalBarChart) view.findViewById(R.id.cht_Grafico_022);


        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(4f, 0));
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(12f, 3));
        entries.add(new BarEntry(18f, 4));
        entries.add(new BarEntry(9f, 5));

        BarDataSet dataset = new BarDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        BarData data = new BarData(labels, dataset);
        cht_Grafico_021.setData(data); // set the data and list of lables into chart
        cht_Grafico_022.setData(data); // set the data and list of lables into chart

        cht_Grafico_021.setDescription("Description de EstaditicaFragment 21");  // set the description
        cht_Grafico_022.setDescription("Description de EstaditicaFragment 22");  // set the description


//        dataset.setColors(ColorTemplate.COLORFUL_COLORS); // Colores aleatorios para barras

//        barChart.animateY(5000); // Animar
    }

    private void Grafico_01(View view) {
        cht_Grafico_01 = (LineChart) view.findViewById(R.id.cht_Grafico_01);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(4f, 0));
        entries.add(new Entry(8f, 1));
        entries.add(new Entry(6f, 2));
        entries.add(new Entry(2f, 3));
        entries.add(new Entry(18f, 4));
        entries.add(new Entry(9f, 5));

        LineDataSet dataset = new LineDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        LineData data = new LineData(labels, dataset);

//        dataset.setDrawCubic(true); // Forma Cubical

//        dataset.setDrawFilled(true); // Rellenar por debajo de la linea

//        dataset.setColors(ColorTemplate.COLORFUL_COLORS); // Colores de linea aleatorio

//        pieChart.animateY(5000); // Animacion

        cht_Grafico_01.setData(data); // set the data and list of lables into chart
    }
}