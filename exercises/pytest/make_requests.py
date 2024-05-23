import requests

base_url = "https://sandy.pandemonium.itqc.ru/"


def make_get_request(api_endpoint, params=None):
    """Make GET-request on a session."""
    with requests.Session() as session:
        return session.get(f"{base_url}{api_endpoint}", params=params)
