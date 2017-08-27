package main.java.examination;

import java.util.*;
public class MainAli1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
        while (scanner.hasNextLine()) {
            String[] options = scanner.nextLine().split(";");
            if (options.length < 5) {
                break;
            }
            lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]));
        }
        scanner.close();

        // wirte your code here
        List<String> result = calculateUnilateral(lineList);

        for (String str : result) {
            System.out.println(str);
        }
    }
    public static List<String> calculateUnilateral(List<UnilateralLine> lineList) {
        List<String> result = new ArrayList<String>();
        int ruleNumber = 0;
        for(int i = 0 ; i < lineList.size(); i++){
            UnilateralLine linei = lineList.get(i);
            for(int j = i+1; j < lineList.size(); j++){
                UnilateralLine linej = lineList.get(j);
                    if( (linei.getSCen().equals(linej.getECen()) && linei.getSPro().equals(linej.getEPro()) ) && ( linei.getECen().equals(linej.getSCen()) && linei.getEPro().equals(linej.getSPro()) ) ){
                        if(linei.getTType().equals(linej.getTType())) {
                            ruleNumber++;
                            result.add("rule" + ruleNumber + ":" + linei.getId() + "+" + linej.getId());

                            lineList.remove(j);
                            lineList.remove(i);
                            j = lineList.size();
                            i--;
                        }else if(linei.getTType().equals("9.6m")){
                            for(int k = j + 1; k < lineList.size(); k++){
                                UnilateralLine linek = lineList.get(k);
                                if((linek.getSCen().equals(linej.getECen()) && linek.getSPro().equals(linej.getEPro()) ) && ( linek.getECen().equals(linej.getSCen()) && linek.getEPro().equals(linej.getSPro()) )){
                                    ruleNumber++;
                                    result.add("rule"+ruleNumber+":"+linei.getId()+"+"+linej.getId()+"+"+linek.getId());
                                    lineList.remove(k);
                                    lineList.remove(j);
                                    lineList.remove(i);
                                    k = lineList.size();
                                    j = lineList.size();
                                    i--;
                                }
                            }
                        }else {
                            for(int k = j + 1; k < lineList.size(); k++){
                                UnilateralLine linek = lineList.get(k);
                                if((linek.getSCen().equals(linei.getECen()) && linek.getSPro().equals(linei.getEPro()) ) && ( linek.getECen().equals(linei.getSCen()) && linek.getEPro().equals(linei.getSPro()) )){
                                    ruleNumber++;
                                    result.add("rule"+ruleNumber+":"+linei.getId()+"+"+linej.getId()+"+"+linek.getId());
                                    lineList.remove(k);
                                    lineList.remove(j);
                                    lineList.remove(i);
                                    k = lineList.size();
                                    j = lineList.size();
                                    i--;
                                }
                            }
                        }

                    }
            }
        }
        for(int i = 0 ; i < lineList.size(); i++){
            UnilateralLine linei = lineList.get(i);
            for(int j = i+1; j < lineList.size(); j++){
                UnilateralLine linej = lineList.get(j);
                if( (linei.getSCen().equals(linej.getECen()) && linei.getSPro().equals(linej.getEPro()) ) || ( linei.getECen().equals(linej.getSCen()) && linei.getEPro().equals(linej.getSPro()) ) ){
                    if( linei.getSCen().equals(linej.getECen()) && linei.getSPro().equals(linej.getEPro()) && linei.getTType().equals(linej.getTType()) ){
                        for(int k = j + 1; k < lineList.size(); k++){
                            UnilateralLine linek = lineList.get(k);
                            if(linek.getSCen().equals(linei.getECen()) && linek.getSPro().equals(linei.getEPro()) && linek.getECen().equals(linej.getSCen()) && linek.getEPro().equals(linej.getSPro())){
                                ruleNumber++;
                                result.add("rule"+ruleNumber+":"+linei.getId()+"+"+linej.getId()+"+"+linek.getId());
                                lineList.remove(k);
                                lineList.remove(j);
                                lineList.remove(i);
                                k = lineList.size();
                                j = lineList.size();
                                i--;
                            }
                        }
                    }else if(linei.getTType().equals(linej.getTType())){
                        for(int k = j + 1; k < lineList.size(); k++){
                            UnilateralLine linek = lineList.get(k);
                            if(linek.getSCen().equals(linej.getECen()) && linek.getSPro().equals(linej.getEPro()) && linek.getECen().equals(linei.getSCen()) && linek.getEPro().equals(linei.getSPro())){
                                ruleNumber++;
                                result.add("rule"+ruleNumber+":"+linei.getId()+"+"+linej.getId()+"+"+linek.getId());
                                lineList.remove(k);
                                lineList.remove(j);
                                lineList.remove(i);
                                k = lineList.size();
                                j = lineList.size();
                                i--;
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0 ; i < lineList.size(); i++){
            UnilateralLine linei = lineList.get(i);
            for(int j = i+1; j < lineList.size(); j++){
                UnilateralLine linej = lineList.get(j);
                if( ( linei.getSPro().equals(linej.getEPro()) ) && (  linei.getEPro().equals(linej.getSPro()) ) && linei.getTType().equals(linej.getTType()) ){


                        for(int k = j + 1; k < lineList.size(); k++){
                            UnilateralLine linek = lineList.get(k);
                            if((linek.getSCen().equals(linej.getECen()) && linek.getSPro().equals(linej.getEPro()) ) && ( linek.getECen().equals(linej.getSCen()) && linek.getEPro().equals(linej.getSPro()) )){
                                ruleNumber++;
                                result.add("rule"+ruleNumber+":"+linei.getId()+"+"+linej.getId()+"+"+linek.getId());
                                lineList.remove(k);
                                lineList.remove(j);
                                lineList.remove(i);
                                k = lineList.size();
                                j = lineList.size();
                                i--;
                            }
                        }


                }
            }
        }
        return result;
    }
    public static class UnilateralLine {
        private String id;
        private String sCen;//出发分拨
        private String sPro;//出发省
        private String eCen;//到达分拨
        private String ePro;//到达省
        //9.6m/17.5m
        private String tType;//车型
        public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro,String tType) {
            this.id = id;this.sCen = sCen;this.sPro = sPro;this.eCen = eCen;this.ePro = ePro;this.tType = tType;}
        public String getId() {return id;}
        public void setId(String id) {this.id = id;}
        public String getSCen() {return sCen;}
        public void setSCen(String ePro) {this.ePro = ePro;}
        public String getSPro() {return sPro;}
        public void setSPro(String sPro) {this.sPro = sPro;}
        public String getECen() {return eCen;}
        public void setECen(String eCen) {this.eCen = eCen;}
        public String getEPro() {return ePro;}
        public void setEPro(String ePro) {this.ePro = ePro;}
        public String getTType() {return tType;}
        public void setTType(String tType) {this.tType = tType;}
    }

}
