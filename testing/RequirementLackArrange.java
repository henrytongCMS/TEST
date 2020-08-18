package com.testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequirementLackArrange {

	public static void main(String[] args) {

		List<MOManufactureMaterialRequirement> materialRequirements = new ArrayList<MOManufactureMaterialRequirement>();

		materialRequirements.add(new MOManufactureMaterialRequirement());
		materialRequirements.add(new MOManufactureMaterialRequirement());
		materialRequirements.add(new MOManufactureMaterialRequirement());
		materialRequirements.add(new MOManufactureMaterialRequirement());
		materialRequirements.add(new MOManufactureMaterialRequirement());

		materialRequirements.get(0).setmRequireAmount(40);
		materialRequirements.get(1).setmRequireAmount(2);
		materialRequirements.get(2).setmRequireAmount(14);
		materialRequirements.get(3).setmRequireAmount(15);
		materialRequirements.get(4).setmRequireAmount(22);

		List<ManufactureMaterialLack> materialLacks = new ArrayList<ManufactureMaterialLack>();

		materialLacks.add(new ManufactureMaterialLack());
		materialLacks.add(new ManufactureMaterialLack());
		materialLacks.add(new ManufactureMaterialLack());
		materialLacks.add(new ManufactureMaterialLack());
		materialLacks.add(new ManufactureMaterialLack());

		materialLacks.get(0).setmLackAmount(2);
		materialLacks.get(1).setmLackAmount(22);
		materialLacks.get(2).setmLackAmount(30);
		materialLacks.get(3).setmLackAmount(5);
		materialLacks.get(4).setmLackAmount(1);

		Map<String, List<MOManufactureMaterialRequirement>> materialRequirementsMap = new HashMap<String, List<MOManufactureMaterialRequirement>>();
		materialRequirementsMap.put("A_1", materialRequirements);

		Map<String, List<ManufactureMaterialLack>> materialLacksMap = new HashMap<String, List<ManufactureMaterialLack>>();
		materialLacksMap.put("A_1", materialLacks);

		List<MOMMR2MML> resultList = create(materialRequirementsMap, materialLacksMap);

		System.out.println("---------------------------------------------");

		resultList.forEach(result -> System.out.println("[INFO] index: " + result.getIndx() + "; lackAmount: " + result.getLackAmount()));

	}

	public static List<MOMMR2MML> create(Map<String, List<MOManufactureMaterialRequirement>> materialRequirementsMap, Map<String, List<ManufactureMaterialLack>> materialLacksMap) {

		List<MOMMR2MML> mommr2mmlList = new ArrayList<MOMMR2MML>();

		for (Object key : materialRequirementsMap.keySet()) {

			if (materialLacksMap.containsKey(key)) {

				System.out.printf("[INFO] materialRequirement key: %s%n", key);

				List<MOManufactureMaterialRequirement> materialRequirements = materialRequirementsMap.get(key);
				List<ManufactureMaterialLack> materialLacks = materialLacksMap.get(key);

				int ri = 0;
				int li = 0;

				double materialRequirementLeft = materialRequirements.get(0).getmRequireAmount();
				double materialLackLeft = materialLacks.get(0).getmLackAmount();

				boolean toBreak = false;
				boolean toLog = false;

				int breakId = 0;
				int indx = 0;

				while (!toBreak) {
					MOMMR2MML mommr2mml = new MOMMR2MML();
					mommr2mml.setIndx(indx);
					double lackAmount;
					System.out.println("[INFO] ri: " + ri + "; li: " + li + "; materialLackLeft: " + materialLackLeft + "; materialRequirementLeft: " + materialRequirementLeft);

					if (materialRequirementLeft >= materialLackLeft) {
						lackAmount = materialLackLeft;
						materialRequirementLeft -= lackAmount;
						if (li < materialLacks.size() - 1) {
							indx++;
							li++;
							materialLackLeft = materialLacks.get(li).getmLackAmount();
						} else {
							if (materialRequirementLeft > 0) {
								breakId = ri;
								toLog = true;
							}
							toBreak = true;
						}
						if (materialRequirementLeft == 0 && ri < materialRequirements.size() - 1) {
							indx = 0;
							ri++;
							materialRequirementLeft = materialRequirements.get(ri).getmRequireAmount();
						}
					} else {
						lackAmount = materialRequirementLeft;
						materialLackLeft -= lackAmount;
						if (ri < materialRequirements.size() - 1) {
							indx = 0;
							ri++;
							materialRequirementLeft = materialRequirements.get(ri).getmRequireAmount();
						} else {
							toBreak = true;
						}
					}
					mommr2mml.setLackAmount(lackAmount);
					mommr2mmlList.add(mommr2mml);
					System.out.println("[INFO] lackAmount: " + lackAmount);
				}
				if (toLog) {
					System.out.printf("[INFO] materialRequirement left: %.1f %n", materialRequirementLeft);
					for (int i = breakId + 1; i < materialRequirements.size(); i++) {
						System.out.printf("[INFO] materialRequirement left: %.1f %n", materialRequirements.get(i).getmRequireAmount());
					}
				}
			} else {
				System.out.printf("[INFO] materialRequirement key : %s does not contain in materialLack key. %n", key);
			}
		}

		return mommr2mmlList;

	}

	public static class ManufactureMaterialLack {

		private double mLackAmount;

		public double getmLackAmount() {
			return mLackAmount;
		}

		public void setmLackAmount(double mLackAmount) {
			this.mLackAmount = mLackAmount;
		}

	}

	public static class MOManufactureMaterialRequirement {

		private double mRequireAmount;

		public double getmRequireAmount() {
			return mRequireAmount;
		}

		public void setmRequireAmount(double mRequireAmount) {
			this.mRequireAmount = mRequireAmount;
		}

	}

	public static class MOMMR2MML {

		private int indx;
		private double lackAmount;

		public int getIndx() {
			return indx;
		}

		public void setIndx(int indx) {
			this.indx = indx;
		}

		public double getLackAmount() {
			return lackAmount;
		}

		public void setLackAmount(double lackAmount) {
			this.lackAmount = lackAmount;
		}

	}

}
