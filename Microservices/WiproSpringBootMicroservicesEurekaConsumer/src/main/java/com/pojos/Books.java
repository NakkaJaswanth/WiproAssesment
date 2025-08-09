package com.pojos;

public class Books {
Integer bookid;
String bookanme;
Double bookcost;
public Books() {}
public Books(Integer bookid, String bookanme, Double bookcost) {
super();
this.bookid = bookid;
this.bookanme = bookanme;
this.bookcost = bookcost;
}
public Integer getBookid() {
return bookid;
}
public void setBookid(Integer bookid) {
this.bookid = bookid;
}
public String getBookanme() {
return bookanme;
}
public void setBookanme(String bookanme) {
this.bookanme = bookanme;
}
public Double getBookcost() {
return bookcost;
}
public void setBookcost(Double bookcost) {
this.bookcost = bookcost;
}
@Override
public int hashCode() {
final int prime = 31;
int result = 1;
result = prime * result + ((bookanme == null) ? 0 : bookanme.hashCode());
result = prime * result + ((bookcost == null) ? 0 : bookcost.hashCode());
result = prime * result + ((bookid == null) ? 0 : bookid.hashCode());
return result;
}
@Override
public boolean equals(Object obj) {
if (this == obj)
return true;
if (obj == null)
return false;
if (getClass() != obj.getClass())
return false;
Books other = (Books) obj;
if (bookanme == null) {
if (other.bookanme != null)
return false;
} else if (!bookanme.equals(other.bookanme))
return false;
if (bookcost == null) {
if (other.bookcost != null)
return false;
} else if (!bookcost.equals(other.bookcost))
return false;
if (bookid == null) {
if (other.bookid != null)
return false;
} else if (!bookid.equals(other.bookid))
return false;
return true;
}
@Override
public String toString() {
return "Books [bookid=" + bookid + ", bookanme=" + bookanme + ", bookcost=" + bookcost +"]";
}
}
