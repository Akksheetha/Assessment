import pytest
from pages.search_page import SearchPage

class TestSearch:

    @pytest.mark.smoke
    def test_search(self, setup_and_teardown):
        driver = setup_and_teardown
        search_page = SearchPage(driver)
        results = search_page.search_product("MacBook")
        assert any("MacBook" in result for result in results)