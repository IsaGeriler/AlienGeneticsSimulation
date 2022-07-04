# AlienGeneticsSimulation
AlienGeneticsSimulation project.

-- Description --

Consider an life form called compAlien, whose genetic material is coded by three characters: ‘X’, ’Y’, ’Z’.
An individual of this species has a code length of 128 and made up of these three characters.

There are certain properties of this species, which can be identified by analyzing the genetic code: 
- Health: An individual’s health is proportional to the number of distinct “YXZ” sequences in its code. Health affects the individual’s chance of producing offsprings. 
- Gender: gender is determined by the last (128th) character: males have ‘Y’; females have ‘X’ or ‘Z’ on their code as the last character. 
- Reproduction: When two individuals of opposite gender mate, they can produce an offspring with a probability proportional to the sum of their healths.
The probability of having an offspring for two opposite gender individuals X and Y is formulated as follows: p_reproduce = (Health_X + Health_Y) / N
(In this program, N is taken/assumed as 84.00 and the formula taken as: (findAlienHealth(alienA) + findAlienHealth(alienB)) / 84.0) * 100.0)

-- Methods/Options --

1) Mate two compAliens/compAliens: The user can enter the IDs of two compAliens to mate them. The program will show the result of reproduction.
2) Randomly mate a set of compAliens: The program will ask the user to enter number of randomly chosen compAlien pairs and will simulate their reproduction.
3) Show statistics: : Find number of females and males, find number of compAliens having health of H (a user given number) or higher, 
shows the percentage of female compAlien population that has 'X' or 'Z' as their last genetic code (separately), shows which compAlien has illness or not.
4) compAliens' preference of wrestling promotions: A random number will be generated and the corresponding index will be the compAliens' favorite wrestling promotion.
Promotion array is as follows: {"WWE", "AEW", "IMPACT", "GCW", "OZ-ACADEMY", "NWA", "PWG", "DDT",
                            "スターダム/STARDOM", "プロレスリングノア/NOAH", "新日本プロレス/NJPW", "全日本プロレス/AJPW",
                            "GLEAT", "東京女子プロレス/TJPW", "アイスリボン/Ice Ribbon", "天龍プロジェクト/Tenryu Project",
                            "大日本プロレス/BJW", "プロレスリングWAVE/WAVE", "SEAdLINNNG", "マーベラス/Marvelous",
                            "JTO", "Gatoh Move", "Michinoku Pro", "FMW-E", "ガンバレプロレス/GanPro"}
5) Wipe out all of the compAliens: A random number will be generated to decide the fate of each and every compAlien out there.
Possible death reasons array is as follows: {"from a random handgun bullet", "after taking a dangerous neck bump",
                            "from an explosion", "from eating too much", "from drinking 7L of water",
                            "after falling from a high building"}
