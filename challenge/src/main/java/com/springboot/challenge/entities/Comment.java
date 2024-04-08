// package com.springboot.challenge.entities;

// import java.io.Serializable;
// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.util.concurrent.TimeUnit;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
// import jakarta.persistence.Transient;

// @Entity
// @Table(name = "comments")
// public class Comment implements Serializable {

//     private static final long serialVersionUID = 1L;

//     @Id
// 	@GeneratedValue(strategy=GenerationType.IDENTITY)
// 	private Long id;
//     private Date date;
//     private String content;
//     // private Post post;

//     @Transient
//     private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy (HH:mm)");

//     public Comment() {
//     }

//     public Comment(Long id, Date date, String content) {
//         this.id = id;
//         this.date = date;
//         this.content = content;
//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Date getDate() {
//         return date;
//     }

//     public void setDate(Date date) {
//         this.date = date;
//     }

//     public String getContent() {
//         return content;
//     }

//     public void setContent(String content) {
//         this.content = content;
//     }

//     // public Post getPost() {
//     //     return post;
//     // }

//     public String timeAgo() {
//         Date nowDate = new Date();
//         long diffMilliseconds = nowDate.getTime() - date.getTime();
//         long diffSeconds = TimeUnit.MILLISECONDS.toSeconds(diffMilliseconds);
//         long diffMinutes = TimeUnit.MILLISECONDS.toMinutes(diffMilliseconds);
//         long diffHours = TimeUnit.MILLISECONDS.toHours(diffMilliseconds);
//         long diffDays = TimeUnit.MILLISECONDS.toDays(diffMilliseconds);
    
//         if (diffSeconds <= 59) {
//             return diffSeconds + " seconds ago";
//         } else if (diffMinutes <= 59) {
//             return diffMinutes + " minutes ago";
//         } else if (diffHours <= 23) {
//             return diffHours + " hours ago";
//         } else {
//             return diffDays + " days ago";
//         }
//     }

//     public String formattedDate() {
//         return sdf.format(this.getDate());
//     }

//     @Override
//     public int hashCode() {
//         final int prime = 31;
//         int result = 1;
//         result = prime * result + ((id == null) ? 0 : id.hashCode());
//         return result;
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (this == obj)
//             return true;
//         if (obj == null)
//             return false;
//         if (getClass() != obj.getClass())
//             return false;
//         Comment other = (Comment) obj;
//         if (id == null) {
//             if (other.id != null)
//                 return false;
//         } else if (!id.equals(other.id))
//             return false;
//         return true;
//     }
// }
