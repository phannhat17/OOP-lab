public class Cart {
    
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered > MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full!");
        } else {
            itemsOrdered[qtyOrdered] = disc;
            System.out.println(disc.getTitle() + " has been added!");
            qtyOrdered +=1;
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        if (dvdList.length > MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full!");
        } else {
            for (int i = 0; i < dvdList.length; i++) {
                itemsOrdered[qtyOrdered] = dvdList[i];
                System.out.println(dvdList[i].getTitle() + " has been added!");
                qtyOrdered +=1 ;
            }
    
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
        DigitalVideoDisc [] dvdList = {dvd1, dvd2};
        addDigitalVideoDisc(dvdList);
    }


    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == 0) {
            System.out.println("Nothing to remove!");
        } else {
            int index = -1;
            for (int i = 0; i < qtyOrdered; i++) {
                if (itemsOrdered[i] == disc) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                System.out.println("Disc not found in cart!");
            } else {
                for (int i = index; i < qtyOrdered - 1; i++) {
                    itemsOrdered[i] = itemsOrdered[i + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println(disc.getTitle() + " has been removed from the cart.");
            }
        }
    }


    public float totalCost(){
        float totalCost = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            totalCost += itemsOrdered[i].getCost();
        }
        return totalCost;
    }

}
