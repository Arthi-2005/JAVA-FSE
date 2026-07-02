/* React = JavaScript library for building UIs
   Component-based, reusable, virtual DOM */

public class ReactDemo {
    public static void main(String[] args) {
        System.out.println("=== React SPA (Single Page Application) ===");
        System.out.println();
        System.out.println("Key Concepts:");
        System.out.println("  Components   - Reusable UI blocks");
        System.out.println("  JSX          - HTML in JavaScript");
        System.out.println("  Props        - Data passed to components");
        System.out.println("  State        - Component's own data");
        System.out.println("  Hooks        - useState, useEffect");
        System.out.println();
        System.out.println("Component Example:");
        System.out.println("  function UserCard({ name, email }) {");
        System.out.println("      return <div><h2>{name}</h2><p>{email}</p></div>;");
        System.out.println("  }");
        System.out.println();
        System.out.println("SPA: ONE HTML page, JavaScript changes views");
        System.out.println("  No page reloads => Fast user experience");
    }
}