/*

Copyright 2024 Massimo Santini

This file is part of "Programmazione 2 @ UniMI" teaching material.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This material is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this file.  If not, see <https://www.gnu.org/licenses/>.

 */
package it.unimi.di.prog2.e03;

import java.util.Scanner;

/**
 * Vedi <a
 * href=
 * "https://github.com/mapio/labprog/blob/master/esercizi/bounding_box/Testo.md">testo</a>,
 */
public class BoundingBox {

    /**
     * .
     */
    private BoundingBox() {
    }

    /*- Completa il seguente main*/
    public static void main(String[] args) {
        int firstStarLine = Integer.MAX_VALUE, firstStarColumn = Integer.MAX_VALUE;
        int lastStarLine = Integer.MIN_VALUE, lastStarColumn = Integer.MIN_VALUE;
        int line = 0;

        try (Scanner s = new Scanner(System.in)) {
            while (s.hasNext()) {
                final String linea = s.nextLine();

                int firstStarInLine = linea.indexOf('*'); // search for * occurrences

                if (firstStarInLine == -1) { // if none is found, go to next line
                    line++;
                    continue;
                } else {                        // if any is found
                    if (line < firstStarLine) { // check if it's the first line to have one
                        firstStarLine = line;   // if so, update the first line occurrence
                    }

                    // if the first star in line is in a column that precedes the previously
                    // found first column containing stars, update it
                    if (firstStarInLine < firstStarColumn) {
                        firstStarColumn = firstStarInLine;
                    }

                    // if the last star in line is in a column that follows the previously
                    // found last column containing stars, update it
                    int lastStarInLine = linea.lastIndexOf('*');
                    if (lastStarInLine > lastStarColumn) {
                        lastStarColumn = lastStarInLine;
                    }

                    if (line > lastStarLine) {
                        lastStarLine = line;
                    }
                }
                line++;
            }
        }
        System.out.printf("%d %d", lastStarLine - firstStarLine + 1, lastStarColumn - firstStarColumn + 1);
    }
}
