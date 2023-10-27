/*

Copyright 2023 Massimo Santini

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

package it.unimi.di.prog2.h09;

import java.util.ArrayList;
import java.util.List;

public class IntSetsClient {

  public static void main(String args[]) {
    int[] a = new int[args.length];
    List<Integer> asList = new ArrayList<>(a.length);
    IntSet S = new IntSet();
    int i = 0;
    for (String s : args) {
      int x = Integer.parseInt(s);
      a[i++] = x;
      asList.add(x);
      S.insert(x);
    }
    for (int x : a) if (S.isIn(x)) System.out.println('A');
    while (S.size() > 0) {
      int x = S.choose();
      if (asList.indexOf(x) != -1) System.out.println('S');
      S.remove(x);
    }
  }
}