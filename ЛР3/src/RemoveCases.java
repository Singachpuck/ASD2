public enum RemoveCases {
    FIRST_CASE, // node is root
    SECOND_CASE, // parent - black, sibling - red
    THIRD_CASE, // parent - black, sibling - black, sibling's children - black
    FOURTH_CASE, // parent - red, sibling - black, sibling's children - black
    FIFTH_CASE, // parent - black, sibling - black, sibling's right children - black, sibling's left children - red
    SIXTH_CASE, // parent - any, sibling - black, sibling's right children - red
    OTHER_CASE
}
