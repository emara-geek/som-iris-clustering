package com.emaraic.utils;

import com.emaraic.models.Iris;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Taha Emara 
 * Website: http://www.emaraic.com 
 * Email : taha@emaraic.com
 * Created on: Nov 22, 2017
 */
public class DatasetReader {

    public static List<Iris> readFile(String path) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        List<Iris> irises = new ArrayList();
        try {

            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                Iris iris = new Iris();
                iris.setSepal_length(new Double(data[0]));
                iris.setSepal_width(new Double(data[1]));
                iris.setPetal_length(new Double(data[2]));
                iris.setPetal_width(new Double(data[3]));
                iris.setType(data[4]);
                irises.add(iris);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return irises;
    }
}
