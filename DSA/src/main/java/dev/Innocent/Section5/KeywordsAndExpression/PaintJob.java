package dev.Innocent.Section5.KeywordsAndExpression;

public class PaintJob {
    public static int getBucketCount(double width, double height, double areaPerBucket, double extraBuckets){
        double area;
        int bucketNeeded;

        if(width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets <= 0){
            return -1;
        }

        area = width * height;
        bucketNeeded = (int) (Math.ceil(area/areaPerBucket) - extraBuckets);
        return bucketNeeded;
    }
}