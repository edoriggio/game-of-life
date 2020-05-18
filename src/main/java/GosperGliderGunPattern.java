package src.main.java;

public class GosperGliderGunPattern extends PatternFactory {

    public GosperGliderGunPattern(BorderRule rule) {
        super(9,36, rule);
        colPositions = new int[]{0 ,1 ,1 ,2 ,2 ,2 ,2 ,2 ,2 ,3 ,3 ,3 ,3 ,3 ,3 ,4 ,4 ,4 ,4 ,4 ,4 ,
                                    5 ,5 ,5 ,5 ,5 ,5 ,5 ,5 ,6 ,6 ,6 ,7 ,7 ,8 ,8 };
        rowPositions = new int[]{24,22,24,12,13,20,21,34,35,11,15,20,21,34,35,0 ,1 ,10,16,20,21,
                                    0 ,1 ,10,14,16,17,22,24,10,16,24,11,15,12,13};
    }
}
