package util;

import data.HumanBeing;

import java.util.TreeSet;

/**
 * processes file values
 */
public class ParserControl {
    public String[] content;

    public ParserControl() {
    }

    public ParserControl(String st) {
        this.content = st.split(",",-1);
    }

    /**
     * convert csv
     * @param tree collection for convert
     * @return string after convert file in csv
     */
    public String infile(TreeSet<HumanBeing> tree) {
        String sfile = new String();
        String[] fparameter = new String[tree.size() * 9];
        int i = 0;
        for (HumanBeing o : tree) {
            fparameter[i] = o.getName();
            fparameter[i + 1] = String.valueOf(o.getCoordinates().getX());
            fparameter[i + 2] = String.valueOf(o.getCoordinates().getY());
            fparameter[i + 3] = String.valueOf(o.getRealHero());
            fparameter[i + 4] = String.valueOf(o.getHasToothpick());
            fparameter[i + 5] = String.valueOf(o.getImpactSpeed());
            fparameter[i + 6] = String.valueOf(o.getWeaponType());
            fparameter[i + 7] = String.valueOf(o.getMood());
            if(o.getCar()!=null){
                fparameter[i + 8] = String.valueOf(o.getCar().getCool());
            }
            else {
                fparameter[i + 8] = String.valueOf(o.getCar());
            }
            i = i + 9;
        }
        for (i = 0; i < fparameter.length; i = i + 9) {
            if(i> fparameter.length-10){
                sfile = sfile + fparameter[i] + "," + fparameter[i + 1] + "," + fparameter[i + 2] + "," + fparameter[i + 3] + ","
                        + fparameter[i + 4] + "," + fparameter[i + 5] + "," + fparameter[i + 6].replace("null","") + "," + fparameter[i + 7].replace("null","") + "," + fparameter[i + 8].replace("null","") ;
            }
            else {
            sfile = sfile + fparameter[i] + "," + fparameter[i + 1] + "," + fparameter[i + 2] + "," + fparameter[i + 3] + ","
                    + fparameter[i + 4] + "," + fparameter[i + 5] + "," + fparameter[i + 6].replace("null","") + "," + fparameter[i + 7].replace("null","") + "," + fparameter[i + 8].replace("null","") + "\n";
            }
        }
        return sfile;
    }
}