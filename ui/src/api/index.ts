export const _fetch = () => {
  const customFetch = async (url: string, options: any = {}) => {
    const defaultMethod = 'GET';
    const defaultHeaders = {
      'Content-Type': 'application/json',
      Accept: 'application/json',
    };
    const controller = new AbortController();
    options.signal = controller.signal;

    options.method = options.method || defaultMethod;
    options.headers = options.headers
      ? {
          ...defaultHeaders,
          ...options.headers,
        }
      : defaultHeaders;

    options.body = JSON.stringify(options.body) || false;
    if (!options.body) delete options.body;

    setTimeout(() => {
      controller.abort();
    }, 3000);

    try {
      const response = await fetch(url, options);
      return await response.json();
    } catch (err) {
      return err;
    }
  };
  const get = (url: string, options = {}) => customFetch(url, options);
  return {
    get,
  };
};
