# https://leetcode.com/problems/reverse-words-in-a-string/description/

# Given an input string, reverse the string word by word.

# For example,
# Given s = "the sky is blue",
# return "blue is sky the".


class ReverseWords(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
        list_of_words = s.split()
        reverse = ''
        for word in reversed(list_of_words):
            reverse += ' ' + word

        return reverse.strip()

if __name__ == "__main__":
    rw = ReverseWords()
    print(rw.reverseWords("the sky is blue"))