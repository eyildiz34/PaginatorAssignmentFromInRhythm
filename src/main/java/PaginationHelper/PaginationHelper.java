package PaginationHelper;

import java.util.List;

public class PaginationHelper {

    public List<Character > collection;
    public int itemsForEachPage;
    /**
     *
     * @param collection
     * @param itemsForEachPage
     */
    public PaginationHelper(List<Character> collection, int itemsForEachPage) {
        this.collection=collection;
        this.itemsForEachPage =itemsForEachPage;
    }
    /**
     *
     * @return int
     */
    public int itemCount() {
        return collection.size();
    }
    /**
     *
     * @return int
     */
    public int pageCount() {
        int totalNumberOfItems = collection.size();
        int pageNumber = totalNumberOfItems% itemsForEachPage;
        int totalPages = 0;
        if(pageNumber != 0){
            totalPages = totalNumberOfItems/ itemsForEachPage +1;
        }else{
            totalPages = totalNumberOfItems/ itemsForEachPage;
        }
        return totalPages;
    }
    /**
     *
     * @param pageIndex
     * @return int
     */
    public int pageItemCount(int pageIndex) {
        int totalPages = this.pageCount();
        int totalNumberOfItems = collection.size();
        int pageNumber = totalNumberOfItems% itemsForEachPage;
        if(pageIndex<0 || pageIndex>=totalPages){
            return -1;
        }
        else{
            if(pageNumber !=0 && pageIndex==totalPages-1){
                return pageNumber;
            }else{
                return itemsForEachPage;
            }
        }
    }
    /**
     *
     * @param itemIndex
     * @return int
     */
    public int pageIndex(int itemIndex) {
        int totalNumberOfItems = collection.size();
        if(itemIndex<=totalNumberOfItems && itemIndex >0){
            return itemIndex / itemsForEachPage;
        }else{
            return -1;
        }
    }
}
