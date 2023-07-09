package SystemDesign;

// https://www.educative.io/courses/grokking-the-system-design-interview/m2ygV4E81AR

public class TinyURL {

}

/*

    Requirements:

        1. Requirements and Goals of the System
            1a. Functional Requirements:
            1b. Non-Functional Requirements:
            1c. Extended Requirements:

        2. Capacity Estimation and Constraints
            2a. Traffic estimates:
            2b. Storage estimates:
            2c. Bandwidth estimates:
            2d. Memory estimates:
            2e. High-level estimates:

        3. System APIs
            3a. createURL()
            parameters:
            returns:
            3b. deleteURL()
            parameters:
            returns:

        4. Database Design
            4a. Observations
                a. we need to store billions of records
                b. each object we store is small (less than 1K)
                c. there are no relationships between records
                d. our service is read-heavy
            4b. Database Schema:
                a. URL table
                    - PK Hash:varchar(167)
                    - OrginalURL: varchar
                b. User table

        5. Basic System Design and Algorithm
            5a. Encode actual URL
            5b. Generating keys offline
                - Key generation service


       6. Data Partitioning and Replication
            6a. Range based partitioning
            6b. Hash based partitioning


       7. Cache
            7a. Cache Size:
            7b. Cache Eviction policy
            7c. Cache replica updates


       8. Load Balancer
            8a. clients and servers
            8b. servers and databases
            8c. servers and caches


      9. Purging of DB cleanup
            9a. Cleanup service


      10. Telemetry

      11. Security and Permissions











 */
