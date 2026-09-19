        </AuthContext.Provider>
    );
};

// Custom hook to easily consume the authentication context
export const useAuth = () => useContext(AuthContext);