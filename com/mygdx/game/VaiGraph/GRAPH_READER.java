package com.mygdx.game.VaiGraph;

import com.badlogic.gdx.math.Vector2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GRAPH_READER {
    private String FileText = "";
    public GRAPH_READER(String FilePath) throws FileNotFoundException {
        File file = new File(FilePath);
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            FileText += reader.nextLine();
        }
    }
    public String getFileText() {
        return FileText;
    }

    public Vector2[] GetCLS_Vector2Array() {
        int vec2_len = 0;

        for (int i = 0; i < FileText.length(); i++) {
            if (FileText.charAt(i) == '<') {
                vec2_len++;
            }
        }
        Vector2[] vec2 = new Vector2[vec2_len];
        int vec2_i = 0;
        String pre_num = "";
        for (int i = 0; i < FileText.length(); i++) {
            if (FileText.charAt(i) == '<') {
                char type = 'x';
                int x = 0;
                int y = 0;
                while (FileText.charAt(i) != '>') {
                    i++;
                    if (FileText.charAt(i) != ' ') {
                        pre_num += FileText.charAt(i);
                    }
                    if (FileText.charAt(i) == ',' && type == 'x') {
                        x = Integer.parseInt(pre_num);
                        type = 'y';
                        pre_num = "";
                    }
                    if (FileText.charAt(i) == ',' && type == 'y')
                    {
                        y = Integer.parseInt(pre_num);
                    }
                }
                vec2[vec2_i] = new Vector2(x, y);
            }
            vec2_i++;
        }

        return vec2;
    }

}
