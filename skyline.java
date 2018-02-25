package leetcode;

import java.util.*;

public class skyline {
	
	 public List<int[]> getSkyline(int[][] buildings) {
	        if (buildings.length == 0) {
	            return Collections.emptyList();
	        }
	        Building[] lefts = new Building[buildings.length];
	        Building[] rights = new Building[buildings.length];
	        for (int i = 0; i < buildings.length; i++) {
	            int[] b = buildings[i];
	            Building building = new Building(b[0], b[1], b[2]);
	            rights[i] = lefts[i] = building;
	        }
	        Arrays.sort(lefts, (a, b) -> {
	            if (a.left != b.left) {
	                return Integer.compare(a.left, b.left);
	            }
	            //descending sort according to height
	            return Integer.compare(b.height, a.height);
	        });
	        Arrays.sort(rights, (a, b) -> {
	            if (a.right != b.right) {
	                return Integer.compare(a.right, b.right);
	            }
	            //ascending sort according to height
	            return Integer.compare(a.height, b.height);
	        });

	        System.out.println(Arrays.toString(lefts));
	        System.out.println(Arrays.toString(rights));
	        List<int[]> result = new ArrayList<>();
	        TreeSet<Building> set = new TreeSet<>();
	        int leftsIndex = 1;
	        int rightsIndex = 0;
	        int h = lefts[0].height;
	        int top = h;
	        set.add(lefts[0]);
	        result.add(new int[] { lefts[0].left, top });
	        int index = 0;
	        while (rightsIndex < buildings.length) {
	            if (leftsIndex == buildings.length || rights[rightsIndex].right < lefts[leftsIndex].left) {
	                index = rights[rightsIndex].right;
	                System.out.println("Remove " + rights[rightsIndex]);
	                set.remove(rights[rightsIndex++]);
	            } else {
	                index = lefts[leftsIndex].left;
	                System.out.println("Add " + lefts[leftsIndex]);
	                set.add(lefts[leftsIndex++]);
	            }
	            System.out.println(set);
	            h = set.isEmpty() ? 0 : set.last().height;
	            if (h != top) {
	                top = h;
	                result.add(new int[] { index, top });
	            }
	        }
	        return result;
	    }

	    class Building implements Comparable<Building> {
	        int left;
	        int right;
	        int height;
	        public Building(int left, int right, int height) {
	            this.left = left;
	            this.right = right;
	            this.height = height;
	        }
	        @Override  
	        public int compareTo(Building o) {
	            if (this.height != o.height) {
	                return Integer.compare(this.height, o.height);
	            }
	            if (this.left != o.left) {
	                return Integer.compare(this.left, o.left);
	            }
	            return Integer.compare(this.right, o.right);
	        }
	        @Override
	        public String toString() {
	            return "Building [left=" + left + ", right=" + right + ", height=" + height + "]";
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
