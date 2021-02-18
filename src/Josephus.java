/**
 * This program simulates the Josephus problem
 *
 * @author TBenedek
 */
public class Josephus
{

    private static class Soldier
    {

        private final String name;

        private Soldier(String nam)
        {
            name = nam;

        }

        private String getName()
        {
            return name;
        }

        @Override
        public boolean equals(Object other)
        {
            boolean yes = false;
            if (other != null && other instanceof Soldier
                    && name.equalsIgnoreCase(((Soldier) other).getName()))
            {
                yes = true;
            }
            return yes;
        }

        @Override
        public String toString()
        {
            return name;
        }
    }

    private final static int MINSOLDIERS = 2;
    private final static int MAXSOLDIERS = 10;
    private final static int MAXCOUNT = 10;

    public static void main(String[] args)
    {
        int numOfSoldiers = UI.getInt(UI.Source.SCANNER,
                "Enter the number of soldiers who should be part of the circle",
                MINSOLDIERS,
                MAXSOLDIERS);
        GCLL soldierList = createSoldierList(numOfSoldiers);
        int countdown = UI.getInt(UI.Source.SCANNER,
                "What number should the soldiers be counted by?",
                1,
                MAXCOUNT);
        System.out.println("Initial list of soldiers:\n" + soldierList);
        Soldier[] originalSoldierOrder = saveOrdinals(soldierList, numOfSoldiers);
        executeAndDisplaySoldiers(soldierList, countdown, numOfSoldiers);
        Soldier survivor = (Soldier) soldierList.getFirst();
        int originalOrdinal = findOrdinal(originalSoldierOrder, survivor);
        System.out.println("The surviving soldier is " + soldierList.getFirst()
                + " whose original ordinal point was #" + originalOrdinal);
    }

    private static GCLL createSoldierList(int num)
    {
        GCLL soldierList = new GCLL();
        for (int ix = 1; ix <= num; ix++)
        {
            Soldier soldier = new Soldier("Soldier " + ix);
            soldierList.add(soldier);
        }
        return soldierList;
    }

    private static Soldier[] saveOrdinals(GCLL list, int numOfSoldiers)
    {
        Soldier[] ordinalList = new Soldier[numOfSoldiers];
        for(int ix = 0; ix < numOfSoldiers; ix++)
        {
            ordinalList[ix] = (Soldier)list.getFirst();
            list.advance(1);
        }
        return ordinalList;
    }

    private static void executeAndDisplaySoldiers(GCLL soldiers, int countdown, int numOfSoldiers)
    {
        for (int ix = 1; ix < numOfSoldiers; ix++)
        {
            soldiers.advance(countdown);
            Soldier executed = (Soldier) soldiers.getFirst();
            soldiers.remove(soldiers.getFirst());
            System.out.println("Execution #" + ix + ":\n" + executed + "\n");
        }
    }

    private static int findOrdinal(Soldier[] ordinalList, Soldier survivor)
    {
        int index = 0;
        while(index < ordinalList.length)
        {
            if(ordinalList[index].equals(survivor))
            {
                break;
            }
            index++;
        }
        return index;
    }
}

