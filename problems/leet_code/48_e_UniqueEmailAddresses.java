/* Unique Email Addresses
 *
 * email -> local name + domain name
 *
 * email may contain '.' s and '+' s.
 *
 * on localname when forwarding it removes '.'. This is not for domain.
 *
 * on local name everything after the first '+' sign will be ignored.
 *
 * Given a list of emails, how many actual emails actually receives email.
 */


import java.util.HashSet;


class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> emailMap = new HashSet<>();

        for (String email : emails) {
            if (email.indexOf("@") == -1) {
                continue;
            }
            String localName, domainName; 
            localName = email.split("@")[0];
            domainName = email.split("@")[1];

            localName = localName.replaceAll("\\.", "");
            localName = localName.split("\\+")[0];

            emailMap.add(localName+domainName);
        }

        return emailMap.size();
    }

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@example.com", "test.e.mail+bob.cathy@example.com", "foo@example.com"};

        Solution sol = new Solution();
        System.out.println(sol.numUniqueEmails(emails));

    }
}
